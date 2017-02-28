/**
 * 
 */
package com.models;

/**
 * @author dipanjankarmakar
 *
 */
public class Book {
	
	private String courseName;
	private String session;
	private int year;
	private String instructor;
	private String bookName;
	private String author;
	private String isbn;
	private String comments;
	private boolean isArchived;
	private boolean isLatest;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isArchived() {
		return isArchived;
	}
	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	public boolean isLatest() {
		return isLatest;
	}
	public void setLatest(boolean isLatest) {
		this.isLatest = isLatest;
	}
	@Override
	public String toString() {
		return "Book [courseName=" + courseName + ", session=" + session
				+ ", year=" + year + ", instructor=" + instructor
				+ ", bookName=" + bookName + ", author=" + author + ", isbn="
				+ isbn + ", comments=" + comments + ", isArchived="
				+ isArchived + ", isLatest=" + isLatest + "]";
	}
	
	

}
