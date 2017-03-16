/**
 * 
 */
package com.models;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author dipanjankarmakar
 *
 */

@XmlRootElement
@XmlType(propOrder={"courseName","bookName","author","instructor","session","year","isbn","comments","archived","latest" })
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
	@XmlElement
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSession() {
		return session;
	}
	@XmlElement
	public void setSession(String session) {
		this.session = session;
	}
	public int getYear() {
		return year;
	}
	@XmlElement
	public void setYear(int year) {
		this.year = year;
	}
	public String getInstructor() {
		return instructor;
	}
	@XmlElement
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getBookName() {
		return bookName;
	}
	@XmlElement
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	@XmlElement
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getComments() {
		return comments;
	}
	@XmlElement
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isArchived() {
		return isArchived;
	}
	@XmlElement
	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	public boolean isLatest() {
		return isLatest;
	}
	@XmlElement
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
	
	public static void main(String args[])
	{

		Book book = new Book();
		book.setSession("Spring");
		book.setCourseName("Algorithms");
		book.setAuthor("Coremen");
		book.setInstructor("Baca");
		book.setYear(2017);
		book.setBookName("Introduction to Algorithm");

		try {

			File file = new File("book.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(book, file);
			jaxbMarshaller.marshal(book, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
	

}
