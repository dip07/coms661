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
@XmlRootElement(name="books")
public class Books {
	
	@XmlElement(name = "book", type = Book.class)
	private ArrayList<Book> bookList= new ArrayList<Book>();
	
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public static class Book
	{
		private Integer entryId;
		private String courseNumber;
		private String session;
		private Integer year;
		private String instructorName;
		private String bookName;
		private String author;
		private String ISBN;
		private String comments;
		private Boolean isArchived;
		public Integer getEntryId() {
			return entryId;
		}
		public void setEntryId(Integer entryId) {
			this.entryId = entryId;
		}
		
		public String getCourseNumber() {
			return courseNumber;
		}
		public void setCourseNumber(String courseNumber) {
			this.courseNumber = courseNumber;
		}
		public String getSession() {
			return session;
		}
		public void setSession(String session) {
			this.session = session;
		}
		public Integer getYear() {
			return year;
		}
		public void setYear(Integer year) {
			this.year = year;
		}
		public String getInstructorName() {
			return instructorName;
		}
		public void setInstructorName(String instructorName) {
			this.instructorName = instructorName;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getISBN() {
			return ISBN;
		}
		public void setISBN(String iSBN) {
			ISBN = iSBN;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public Boolean getIsArchived() {
			return isArchived;
		}
		public void setIsArchived(Boolean isArchived) {
			this.isArchived = isArchived;
		}
		@Override
		public String toString() {
			return "Book [entryId=" + entryId + ", courseNumber="
					+ courseNumber + ", session=" + session + ", year=" + year
					+ ", instructorName=" + instructorName + ", bookName="
					+ bookName + ", author=" + author + ", ISBN=" + ISBN
					+ ", comments=" + comments + ", isArchived=" + isArchived
					+ "]";
		}
		
	}

}
