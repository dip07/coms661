/**
 * 
 */
package com.models;

import java.util.ArrayList;

/**
 * @author dipanjankarmakar
 *
 */
public class Books {
	
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
		private String courseName;
		private String Session;
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
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public String getSession() {
			return Session;
		}
		public void setSession(String session) {
			Session = session;
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
			return "Book [entryId=" + entryId + ", courseName=" + courseName
					+ ", Session=" + Session + ", year=" + year
					+ ", instructorName=" + instructorName + ", bookName="
					+ bookName + ", author=" + author + ", ISBN=" + ISBN
					+ ", comments=" + comments + ", isArchived=" + isArchived
					+ "]";
		}
		
		
		
	}

}
