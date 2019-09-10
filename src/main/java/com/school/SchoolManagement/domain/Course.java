/**
 * 
 */
package com.school.SchoolManagement.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ranjeet
 *
 */
@Entity
@Table(name="course_master")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String course_duration;
	@Temporal( TemporalType.TIMESTAMP)
    private Date creation_time;
    private Date updation_time;
    
	
	public Course() {
		
	}
	public Course(String name,String duration,String address) {
		this.name=name;
		this.course_duration=duration;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCourse_duration() {
		return course_duration;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCourse_duration(String course_duration) {
		this.course_duration = course_duration;
	}
	
	/**
	 * @return the updation_time
	 */
	public Date getUpdation_time() {
		return updation_time;
	}
	/**
	 * @param updation_time the updation_time to set
	 */
	public void setUpdation_time(Date updation_time) {
		this.updation_time = updation_time;
	}
	@Override
	public String toString() {
		return "\nCourse [id=" + id + ", name=" + name + ", course_duration=" + course_duration + ", creation_time= " + creation_time + ", updation_time=" + updation_time + "]";
	}
	
	
	
	
}
