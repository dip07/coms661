/**
 * 
 */
package com.models;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * @author dipanjankarmakar
 *
 */

@XmlRootElement(name = "course")
//@XmlType(propOrder={"courseId","courseName","courseNumber"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
	
	private int courseId;
	private String courseName;
	private Long courseNumber;

	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Long getCourseNumber() {
		return courseNumber;
	}
	
	public void setCourseNumber(Long courseNumber) {
		this.courseNumber = courseNumber;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName
				+ ", courseNumber=" + courseNumber + "]";
	}
}
