package com.dao;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.models.BookOld;
import com.models.Course;
import com.models.CourseList;

public class BookXmlDbDao {
	
	@Value("${dbFiles.location}")
	private String dbFilesLocation;
	
	Logger logger= Logger.getLogger(BookXmlDbDao.class);
	
	public ArrayList<BookOld> getBookDataFromDb(BookOld book)
	{

		ArrayList<BookOld> bookList=new ArrayList<BookOld>();
		BookOld book1= new BookOld();
		book1.setCourseName("Intro to Algo");
		book.setSession("Spring");
		book.setYear(2017);
		book.setInstructor("Proff Baca");
		bookList.add(book);
		
		
		
		return bookList;
	}
	
	public CourseList getCoursesDetails()
	{
		CourseList courseList= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(CourseList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation +"course.xml");
			courseList = (CourseList) jaxbUnmarshaller.unmarshal(existingFile);
		}
		catch(Exception e)
		{
			courseList= new CourseList();
			courseList.setCourses(new ArrayList<Course>());
			logger.error("Error while fetching courses " +e.getStackTrace());
		}
		return courseList;
	}

}
