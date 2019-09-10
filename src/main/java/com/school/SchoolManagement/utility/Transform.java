/**
 * 
 */
package com.school.SchoolManagement.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.school.SchoolManagement.domain.Student;
import com.school.SchoolManagement.dto.StudentDto;

/**
 * @author Ranjeet
 *
 */
public class Transform {
	 static Date date ;
	public static Student sDtotoDomain(StudentDto student) {
		if(student.getUpdation_time()!=null && student.getUpdation_time()!="") {
		try {
			
			DateFormat d= new SimpleDateFormat("yyyy-MM-dd");
			date = d.parse(student.getUpdation_time());
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		}
		Student stud=new Student();
		stud.setId(student.getId());
		stud.setName(student.getName());
		stud.setAddress(student.getAddress());
		stud.setClasses(student.getClasses());
		stud.setFather(student.getFather());
		stud.setMobile(student.getMobile());
		stud.setImage(student.getImage());
		stud.setUpdation_time(date);
		return stud;
	}
	
	public static StudentDto sDomaintoDto(Student student) {
		String date="";
		StudentDto std=new StudentDto();
		if(student.getUpdation_time()!=null && student.getUpdation_time().toString()!="") {
		try {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		date=dateFormat.format(student.getUpdation_time()); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		std.setId(student.getId());
		std.setAddress(student.getAddress());
		std.setClasses(student.getClasses());
		std.setUpdation_time(date);
		std.setFather(student.getFather());
		std.setMobile(student.getMobile());
		std.setName(student.getName());
		std.setImage(student.getImage());
		return std;
	}
}
