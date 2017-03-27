/**
 * 
 */
package com.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dipanjankarmakar
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="courses")
public class CourseList {
	
	@XmlElement(name = "course", type = Course.class)
	private ArrayList<Course> courses= new ArrayList<Course>();
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "CourseList [courses=" + courses + "]";
	}
	

}
