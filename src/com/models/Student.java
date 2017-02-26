package com.models;

public class Student {
	
	private Integer student_id;
	private String first_name;
	private String last_name;
	private String gender;
	
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", first_name="
				+ first_name + ", last_name=" + last_name + ", gender="
				+ gender + "]";
	}
}
