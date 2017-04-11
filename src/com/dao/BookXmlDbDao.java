package com.dao;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.models.BookOld;
import com.models.Course;
import com.models.CourseList;
import com.models.Instructors;
import com.models.Instructors.Instructor;
import com.models.Roles;
import com.models.Roles.Role;
import com.models.Users;
import com.models.Users.User;

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

	/**
	 * @param netId
	 * @param password
	 * @return
	 */
	public Role getRoleForValidUser(String netId, String password) {
		
		Users usersList= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation +"users.xml");
			usersList = (Users) jaxbUnmarshaller.unmarshal(existingFile);
		}
		catch(Exception e)
		{
			logger.error("Error while fetching users list " +e.getMessage());
			System.out.println(e.getStackTrace());
		}
		if(usersList==null)
			return null;
		
		for(User user: usersList.getUserList())
		{
			if(netId.compareTo(user.getNetId())==0 && password.compareTo(user.getPassword())==0)
				return user.getRole();
		}
		return null;
	}

	/**
	 * @return
	 */
	public ArrayList<Course> getAllCourses() {
		
		CourseList courseList= null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(CourseList.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"course.xml");
	    	courseList = (CourseList) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No courses found");
	    	e.printStackTrace();
	    }
		if(courseList==null)
			return null;
		else
			return courseList.getCourses();
	}

	/**
	 * @return
	 */
	public ArrayList<Instructor> getInstructorCourseAssignment() {
		Instructors instructorList= null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Instructors.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"instructors.xml");
	    	instructorList = (Instructors) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No existing instructor details");
	    	e.printStackTrace();
	    }
		
		if(instructorList==null)
			return null;
		return instructorList.getInstructorList();
	}

	/**
	 * @param net_id
	 * @return
	 */
	public Instructor getInstructorCourseAssignment(String net_id) {
		return null;
	}

	/**
	 * @return
	 */
	public ArrayList<User> getAllUsers() {
		Users allUsers= null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"users.xml");
	    	allUsers = (Users) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No existing instructor details");
	    	e.printStackTrace();
	    }
		
		if(allUsers==null)
			return null;
		return allUsers.getUserList();
	}

	/**
	 * @param instructorForm
	 * @return
	 */
	public Boolean saveEditInstructorData(Instructor instructorForm) {
		ArrayList<User> userList= getAllUsers();
		String netId="";
		for(User user: userList)
		{
			if(user.getName().compareToIgnoreCase(instructorForm.getName())==0)
			{
				netId=user.getNetId();
				instructorForm.setNetId(netId);
			}
		}
		Instructors instructorList= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Instructors.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation+"instructors.xml");
			instructorList = (Instructors) jaxbUnmarshaller.unmarshal(existingFile);
		}
		catch(Exception e)
		{
			instructorList= new Instructors();
			e.printStackTrace();
		}
		instructorList.getInstructorList().add(instructorForm);

		Marshaller jaxbMarshaller;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Instructors.class);
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File existingFile= new File(dbFilesLocation+"instructors.xml");
			jaxbMarshaller.marshal(instructorList, existingFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
