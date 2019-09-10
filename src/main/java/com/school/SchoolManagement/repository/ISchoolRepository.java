/**
 * 
 */
package com.school.SchoolManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.SchoolManagement.domain.Student;

/**
 * @author Ranjeet
 *
 */
@Repository
public interface ISchoolRepository extends JpaRepository<Student, Integer>{

}
