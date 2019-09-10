/**
 * 
 */
package com.school.SchoolManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.SchoolManagement.dto.StudentDto;

/**
 * @author Ranjeet
 *
 */
@Service
public interface ISchoolService {

	/**
	 * @param student
	 * @return
	 */
	StudentDto addStudents(StudentDto student);

	/**
	 * @return 
	 * 
	 */
	List<StudentDto> viewAllStudent();

	/**
	 * @param student
	 */
	StudentDto getStudentById(StudentDto student);

	/**
	 * @param student
	 */
	void editStudent(StudentDto student);

	/**
	 * @param student
	 */
	void deleteStudent(StudentDto student);
	
}
