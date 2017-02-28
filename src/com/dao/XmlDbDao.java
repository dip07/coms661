package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.models.Book;

public class XmlDbDao {
	
	Logger logger= Logger.getLogger(XmlDbDao.class);
	
	public ArrayList<Book> getBookDataFromDb(Book book)
	{

		ArrayList<Book> bookList=new ArrayList<Book>();
		Book book1= new Book();
		book1.setCourseName("Intro to Algo");
		book.setSession("Spring");
		book.setYear(2017);
		book.setInstructor("Proff Baca");
		bookList.add(book);
		
		
		
		return bookList;
	}

}
