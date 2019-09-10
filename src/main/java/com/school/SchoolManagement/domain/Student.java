/**
 * 
 */
package com.school.SchoolManagement.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ranjeet
 *
 */
@Entity
@Table(name="student_detail")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String father;
	private String address;
	private String mobile;
	private String classes;
	private String image;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation_time;
	private Date updation_time;
	
	public Student() {
		
	}
	public Student(String name,String address, String mobile) {
		this.name=name;
		this.address=address;
		this.mobile=mobile;
	}
	
	
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the father
	 */
	public String getFather() {
		return father;
	}
	/**
	 * @param father the father to set
	 */
	public void setFather(String father) {
		this.father = father;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
	
	/**
	 * @param creation_time the creation_time to set
	 */
	 @PrePersist
	public void setCreation_time() {
		creation_time = new Date();
	}
	
	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", name=" + name + ",father= "+father+", address=" + address + ", mobile=" + mobile
				+ ",image="+image+ ", updation_time=" + updation_time + "]";
	}
	
	
	
}
