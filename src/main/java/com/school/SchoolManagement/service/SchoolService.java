/**
 * 
 */
package com.school.SchoolManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.SchoolManagement.domain.Student;
import com.school.SchoolManagement.dto.StudentDto;
import com.school.SchoolManagement.repository.ISchoolRepository;
import com.school.SchoolManagement.utility.Transform;

/**
 * @author Ranjeet
 *
 */
@Service
public class SchoolService implements ISchoolService{
	Logger logger =LoggerFactory.getLogger(getClass());
	@Autowired
	ISchoolRepository repository;
	/* (non-Javadoc)
	 * @see com.school.SchoolManagement.service.ISchoolService#addStudents(com.school.SchoolManagement.dto.StudentDto)
	 */
	@Override
	public StudentDto addStudents(StudentDto student) {
		Student std=new Student();
		std=Transform.sDtotoDomain(student);
		Student student2 = repository.save(std);
		StudentDto student3=Transform.sDomaintoDto(student2);
		return student3;
	}
	/* (non-Javadoc)
	 * @see com.school.SchoolManagement.service.ISchoolService#viewAllStudent()
	 */
	@Override
	public List<StudentDto> viewAllStudent() {
		List<StudentDto> stud=new ArrayList<>();
		List<Student> student=new ArrayList<>();
		student=  repository.findAll();
		/*for (Student s : student) {
			stud.add(Transform.sDomaintoDto(s));
		}*/
		student.forEach(s1->stud.add(Transform.sDomaintoDto(s1)));
		return stud;
	}
	/* (non-Javadoc)
	 * @see com.school.SchoolManagement.service.ISchoolService#getStudentById(com.school.SchoolManagement.dto.StudentDto)
	 */
	@Override
	public StudentDto getStudentById(StudentDto student) {
		if(student.getId()>0) {
			try {
		Student student2 = repository.getOne(student.getId());
		student=Transform.sDomaintoDto(student2);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return student;
				
	}
	
	/* (non-Javadoc)
	 * @see com.school.SchoolManagement.service.ISchoolService#editStudent(com.school.SchoolManagement.dto.StudentDto)
	 */
	@Transactional
	@Override
	public void editStudent(StudentDto student) {
		try {
			Optional<Student> stud = repository.findById(student.getId());
			StudentDto dto = Transform.sDomaintoDto(stud.get());
			dto.setName(student.getName());
			dto.setAddress(student.getAddress());
			dto.setFather(student.getFather());
			dto.setMobile(student.getMobile());
			Student domain = Transform.sDtotoDomain(dto);
//			logger.info("nothing->"+domain);
			repository.save(domain);
			
				
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see com.school.SchoolManagement.service.ISchoolService#deleteStudent(com.school.SchoolManagement.dto.StudentDto)
	 */
	@Override
	public void deleteStudent(StudentDto student) {
		if(student.getId()>0) {
		try {
			repository.deleteById(student.getId());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
	
}
