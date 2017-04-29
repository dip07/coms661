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
@XmlRootElement(name="instructors")
public class Instructors {
	
	@XmlElement(name = "instructor", type = Instructor.class)
	private ArrayList<Instructor> instructorList= new ArrayList<Instructor>();
	
	public ArrayList<Instructor> getInstructorList() {
		return instructorList;
	}

	public void setInstructorList(ArrayList<Instructor> instructorList) {
		this.instructorList = instructorList;
	}

	public static class Instructor
	{
		private String netId;
		private String name;
		private String instructorForCourse;
		private Boolean isArchived;
		
		public String getNetId() {
			return netId;
		}
		public void setNetId(String netId) {
			this.netId = netId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getInstructorForCourse() {
			return instructorForCourse;
		}
		public void setInstructorForCourse(String instructorForCourse) {
			this.instructorForCourse = instructorForCourse;
		}
		public Boolean getIsArchived() {
			return isArchived;
		}
		public void setIsArchived(Boolean isArchived) {
			this.isArchived = isArchived;
		}
		@Override
		public String toString() {
			return "Instructor [netId=" + netId + ", name=" + name
					+ ", instructorForCourse=" + instructorForCourse
					+ ", isArchived=" + isArchived + "]";
		}
		
	}
}
