/**
 * 
 */
package com.school.SchoolManagement.dto;

/**
 * @author Ranjeet
 *
 */
public class StudentDto {
	int id;
	String name;
	String father;
	String address;
	String mobile;
	String classes;
	String image;
	
	String creation_time;
	String updation_time;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getFather() {
		return father;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
	public String getClasses() {
		return classes;
	}
	public String getCreation_time() {
		return creation_time;
	}
	
	public String getUpdation_time() {
		return updation_time;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public void setCreation_time(String creation_time) {
		this.creation_time = creation_time;
	}
	public void setUpdation_time(String updation_time) {
		this.updation_time = updation_time;
	}
	@Override
	public String toString() {
		return "\nStudentDto [Id="+ id   +", name=" + name + ", father=" + father + ", address=" + address + ", mobile=" + mobile
				+ ", classes=" + classes + ", Image= " +image+", creation_time=" + creation_time + ", updation_time=" + updation_time
				+ "]";
	}
	
	
}
