/**
 * 
 */
package com.models;

/**
 * @author Gaurav Bhatt
 *
 */
public class Vote {
	
	private String voterID;
	private String email;
	private int timeout;
	private String instructor;
	private String isConfidential;
	private String comments;
	private boolean sendRemainder;
	private boolean isArchived;
	private boolean isLatest;
	private Boolen voteDone;
	public String getVote() {
		return voteDone;
	}
	
	public String getVoterId() {
		return voterID;
	}
	public void setVoterId(String ID) {
		this.voterID = ID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
