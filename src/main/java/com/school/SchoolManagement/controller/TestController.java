/**
 * 
 */
package com.school.SchoolManagement.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.school.SchoolManagement.dto.StudentDto;
import com.school.SchoolManagement.service.ISchoolService;

/**
 * @author Ranjeet
 *
 */
@RestController
public class TestController {
	
	@Value("${UPLOADED_FOLDER}")
	private String uploadDirectory;
	@Autowired
	ServletContext context;
	@Autowired
	Environment ev;
	@Autowired
	ISchoolService service;
	
	Logger logger= LoggerFactory.getLogger(getClass());

	@GetMapping("/")
	public ModelAndView uiButtons() {
		ModelAndView view=new ModelAndView();
		view.addObject("name", "My name is Ranjeet");
		view.setViewName("index");
		return view;
		
	}
	@GetMapping("/add-student")
	public ModelAndView addStudent() {
		ModelAndView view=new ModelAndView();
		view.setViewName("addStudent");
		return view;
	}
	@GetMapping("/view-students")
	public ModelAndView viewStudent() {
		ModelAndView view=new ModelAndView();
		List<StudentDto> student=new ArrayList<>();
		student= service.viewAllStudent();
		view.addObject("allStudent",student);
		view.setViewName("viewStudent");
		return view;
	}
	@PostMapping("/add")
	public ModelAndView addStudents( StudentDto student, MultipartFile file){
		ModelAndView view=new ModelAndView();
		StudentDto s=null;
		logger.info(file.getOriginalFilename());
		try {
		Long l= System.currentTimeMillis();
		byte[] bytes= file.getBytes();
		Path path=Paths.get("img/" +l+ "rn.jpg");
		student.setImage(path.toString());
		path=Paths.get(uploadDirectory+path);
		Files.write(path, bytes);
//		logger.error("Student with File ="+student+"path is =>"+path);
		s=service.addStudents(student);
//		logger.info(s+"");
		view.addObject("success","Added succesfully...");
		}catch (Exception e) {
			e.printStackTrace();
			view.addObject("fail","Fail to save data");
		}
		view.setViewName("addStudent");
		return view;
	}
	@PostMapping("/manage-student")
	public StudentDto viewEditStudent(@RequestBody StudentDto student) {
		StudentDto stud=new StudentDto();
//		logger.info(student.getId()+"");
		try {
		stud=service.getStudentById(student);
		}catch (Exception e) {
			e.printStackTrace();
		}
//		logger.info(stud.toString());
		return stud;
	}
	
	@PostMapping("/edit-student")
	public String editStudent(@RequestBody StudentDto student) {
		logger.info("Comming from js=>"+student);
			try {
				service.editStudent(student);
			}catch (Exception e) {
				e.printStackTrace();
				return "Error:Error";
			}
		return "Success";
	}
	
	@PostMapping("/delete-student")
	public String deleteStudent(@RequestBody StudentDto student) {
		try {
			service.deleteStudent(student);
		}catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		return "Success";
	}
	
	
	// Image Call API
	@GetMapping("/img/**")//Last FName in Database(MyImage\doc\filename.jpg)
	public void renderImage(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
			if (uploadDirectory != null) {
			String path = uploadDirectory;
			System.err.println("properties file"+path);
			String servletPath=request.getServletPath();
			System.err.println(servletPath);
			String filename = URLDecoder.decode(servletPath.substring(1), "UTF-8");
			File file = new File(path, filename);
			response.setHeader("Content-Type", context.getMimeType(filename));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			System.err.println("Length of file"+String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
			try {
				Files.copy(file.toPath(), response.getOutputStream());
			} catch (IOException e) {
			}
		}
	}
	//E:/SchoolProject/images/1567065589981rn.jpg
	}
	

