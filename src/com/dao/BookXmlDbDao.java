package com.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.models.BookOld;
import com.models.Books;
import com.models.Books.Book;
import com.models.Course;
import com.models.CourseList;
import com.models.Instructors;
import com.models.Instructors.Instructor;
import com.models.Roles.Role;
import com.models.Users;
import com.models.Users.User;

import constants.CourseBookMessages;

public class BookXmlDbDao {
	
	@Value("${dbFiles.location}")
	private String dbFilesLocation;
	
	Logger logger= Logger.getLogger(BookXmlDbDao.class);
	
	/**
	 * Function to get Book related data from db.
	 * @param book : Object of Class BookOld
	 * @return
	 */
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
	
	/**
	 * Function to get the course details from the XML file in the resource.
	 * @return
	 */
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
	 * Function which returns object of Role for a user
	 * @param netId : email in String format
	 * @param password : Password in String format
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
	 * Function to retrieve all non archived courses.
	 * @return
	 */
	public ArrayList<Course> getAllUnarchivedCourses() {
		
		CourseList courseList= null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(CourseList.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"course.xml");
	    	if(!existingFile.exists())
	    		return null;
	    	courseList = (CourseList) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No courses found");
	    	e.printStackTrace();
	    }
		if(courseList==null)
			return null;
		else{
			ArrayList<Course> validCourseList = new ArrayList<Course>();
			for(Course item : courseList.getCourses())
				if(!item.getIsArchived())
					validCourseList.add(item);
			return validCourseList;
		}
	}

	/**
	 * Function to get the list of instructors and his courses.
	 * @return
	 */
	public ArrayList<Instructor> getInstructorCourseAssignment() {
		Instructors instructorList= null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Instructors.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"instructors.xml");
	    	if(existingFile.exists())
	    		instructorList = (Instructors) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No existing instructor details");
	    	e.printStackTrace();
	    	System.out.println("Error : " + e.getMessage() +"\n"+ e.getStackTrace());
	    }
		
		if(instructorList==null)
			return null;
		ArrayList<Instructor> unArchinstructorList = new ArrayList<Instructor>();
		for(Instructor item : instructorList.getInstructorList())
			if(!item.getIsArchived())
				unArchinstructorList.add(item);
		return unArchinstructorList;
	}

	/**
	 * Get instructor's detail for each course ID
	 * @param course_id : course ID as a string
	 * @return
	 */
	public Instructor getInstructorCourseAssignment(String course_id) {
		Instructors instructors= null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Instructors.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"instructors.xml");
	    	if(existingFile.exists())
	    		instructors = (Instructors) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No existing instructor details");
	    	e.printStackTrace();
	    }
		
		if(instructors==null)
			return null;
		for(Instructor item : instructors.getInstructorList())
		{
			if(!item.getIsArchived() && item.getInstructorForCourse().equals(course_id))
				return item;
		}
		return null;
	}

	/**
	 * Function to get list of all users
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
	 * Function which saves data entered by the instructor to the xml database
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
			if(existingFile.exists())
				instructorList = (Instructors) jaxbUnmarshaller.unmarshal(existingFile);
			else
				instructorList= new Instructors();
		}
		catch(Exception e)
		{
			instructorList= new Instructors();
			e.printStackTrace();
		}
		boolean isPresent = false;
		for(Instructor item : instructorList.getInstructorList())
		{
			if (item.getIsArchived())
				continue;
			if (item.getInstructorForCourse().compareTo(instructorForm.getInstructorForCourse()) == 0)
			{
				item.setNetId(instructorForm.getNetId());
				item.setName(instructorForm.getName());
				item.setInstructorForCourse(instructorForm.getInstructorForCourse());
				item.setIsArchived(instructorForm.getIsArchived());
				isPresent = true;
			}
		}
		if(!isPresent)
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

	/**
	 * Function which saves all the courses and its details as it is entered by the instructor
	 * @param course : object of class Course
	 * @param allowSaving : boolean
	 */
	public String saveCourse(Course course, boolean allowOverwrite) {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(CourseList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			CourseList courseList= null;
			File existingFile= new File(dbFilesLocation+"course.xml");
			if(existingFile.exists())
			{
				courseList = (CourseList) jaxbUnmarshaller.unmarshal(existingFile);
			}
			else
			{
				courseList= new CourseList();
				courseList.setCourses(new ArrayList<Course>());
			}
			boolean isCoursePresent=false;
			for(Course courseItem: courseList.getCourses())
			{
				if(courseItem.getCourseNumber().compareTo(course.getCourseNumber())==0 && !courseItem.getIsArchived())
				{
					if(!allowOverwrite)
						return CourseBookMessages.COURSE_INFO_ALREADY_FILLED.toString();
					
					courseItem.setCourseName(course.getCourseName());
					courseItem.setIsArchived(course.getIsArchived());
					isCoursePresent=true;
				}
			}
			if(!isCoursePresent)
				courseList.getCourses().add(course);

			File file = new File(dbFilesLocation+"course.xml");
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(courseList, file);
			//jaxbMarshaller.marshal(courseList, System.out);
			//System.out.println(file.getAbsoluteFile()+" >> " + file.exists());
			return CourseBookMessages.SUCCESS_TRANSACTION.toString();
		}
		catch(Exception e)
		{
			logger.error("Exception while saving courses : " + e.getStackTrace());
			e.printStackTrace();
			return CourseBookMessages.FAILED_TRANSACTION.toString();
		}
	}

	/**
	 * Function to get all course related details.
	 * @param course_number
	 * @return
	 */
	public Course getCourseDetails(String course_number) {
		CourseList courseList= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(CourseList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation+"course.xml");
			if(!existingFile.exists())
				return null;
			courseList = (CourseList) jaxbUnmarshaller.unmarshal(existingFile);
			for(Course course: courseList.getCourses())
			{
				if(course.getCourseNumber().compareTo(course_number)==0)
					return course;
			}
		}
		catch(Exception e)
		{
			logger.warn("No courses found");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Function to retrieve all book details
	 * @return
	 */
	public ArrayList<Book> getAllBookDetails() {
		Books books= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation+"books.xml");
			if(!existingFile.exists())
				return null;
			books = (Books) jaxbUnmarshaller.unmarshal(existingFile);
		}
		catch(Exception e)
		{
			logger.warn("No courses found");
			e.printStackTrace();
		}
		ArrayList<Book> validBooks= null;
		if(books!=null && books.getBookList().size()>0)
		{
			validBooks= new ArrayList<Book>();
			for(Book book: books.getBookList())
			{
				if(!book.getIsArchived())
					validBooks.add(book);
			}
		}
		return validBooks;
	}

	/**
	 * function to save all book related info
	 * @param book
	 */
	public void saveCourseBookInfo(Book book) {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Books books= null;
			File existingFile= new File(dbFilesLocation+"books.xml");
			if(existingFile.exists())
			{
				books = (Books) jaxbUnmarshaller.unmarshal(existingFile);
			}
			else
			{
				books= new Books();
				books.setBookList(new ArrayList<Books.Book>());
			}
			boolean isBookPresent=false;
			for(Book bookItem: books.getBookList())
			{
				if(bookItem.getIsArchived())
					continue;
				if( bookItem.getCourseNumber().compareTo(book.getCourseNumber())==0 ) 
				{
					bookItem.setBookName(book.getBookName());
					bookItem.setAuthor(book.getAuthor());
					bookItem.setISBN(book.getISBN());
					bookItem.setInstructorName(book.getInstructorName());
					bookItem.setComments(book.getComments());
					bookItem.setYear(book.getYear());
					bookItem.setSession(book.getSession());
					bookItem.setIsArchived(book.getIsArchived());
					isBookPresent=true;
				}
			}
			if(!isBookPresent)
				books.getBookList().add(book);

			File file = new File(dbFilesLocation+"books.xml");
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(books, file);
			//jaxbMarshaller.marshal(courseList, System.out);
			//System.out.println(file.getAbsoluteFile()+" >> " + file.exists());
		}
		catch(Exception e)
		{
			logger.error("Exception while saving courses : " + e.getStackTrace(),e);
			e.printStackTrace();
			System.out.println("Exception " + e.getMessage() + e.getStackTrace());
		}
		
	}

	/**
	 * Function to retrieve book related info to the XML DB
	 * @param courseNumber
	 * @return
	 */
	public Book getCourseBookInfo(String courseNumber) {
		
		Books bookList= null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"books.xml");
	    	if(existingFile.exists())
	    		bookList = (Books) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No existing course book details");
	    	e.printStackTrace();
	    	System.out.println("Error : " + e.getMessage() +"\n"+ e.getStackTrace());
	    }
		
		if(bookList==null)
			return null;
		for(Book book : bookList.getBookList()){
			if(book.getIsArchived())
				continue;
			if(book.getCourseNumber().compareToIgnoreCase(courseNumber) == 0)
				return book;
		}
		return null;
	}

	/**
	 * Function to get book details of previous sessions 
	 * @param year
	 * @param session
	 * @return
	 */
	public ArrayList<Book> getOldCourseBook(int year, String session) 
	{
		
		Books bookList= null;
		ArrayList<Book> oldBookList = null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"books.xml");
	    	if(existingFile.exists())
	    		bookList = (Books) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No existing course book details");
	    	e.printStackTrace();
	    	System.out.println("Error : " + e.getMessage() +"\n"+ e.getStackTrace());
	    }
		
		if(bookList==null)
			return null;
		for(Book book : bookList.getBookList()){
			if(!book.getIsArchived())
				continue;
			if(book.getYear() == year && book.getSession().compareToIgnoreCase(session)==0){
				if(oldBookList == null)
					oldBookList= new ArrayList<Books.Book>();
				oldBookList.add(book);
			}
		}
		return oldBookList;
	}

	/**
	 * Function to get the netID of the user
	 * @param netId
	 * @return
	 */
	public String getUserName(String netId) {

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
		for(User user : allUsers.getUserList()){
			if(user.getNetId().compareToIgnoreCase(netId) == 0)
				return user.getName();
		}
		return null;
	}

	/**
	 * Function to archive all course book related details
	 * @return
	 */
	public Boolean archiveAllCourseBook() {
		

		Books books= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation+"books.xml");
			if(!existingFile.exists())
				return null;
			books = (Books) jaxbUnmarshaller.unmarshal(existingFile);
		
		for(Book book : books.getBookList()){
			if(book.getIsArchived())
				continue;
			book.setIsArchived(true);
		}
		File file = new File(dbFilesLocation+"books.xml");
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(books, file);
		return true;
		}
		catch(Exception e){
			logger.warn("No courses found");
			e.printStackTrace();
			return false;
		}
		
	
	}

	/**
	 * Function to get details of courses for an instructor for which he/she is 
	 * authorized(assigned)
	 * @param userNetId
	 * @param userName
	 * @return
	 */
	public String getAuthorizedCourseInfo(String userNetId, String userName) {

		// check if the instructor has been assigned to any course or not 
		Instructors instructorList= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Instructors.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation+"instructors.xml");
			if(existingFile.exists())
				instructorList = (Instructors) jaxbUnmarshaller.unmarshal(existingFile);
		}
		catch(Exception e)
		{
			logger.warn("No existing instructor details");
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage() +"\n"+ e.getStackTrace());
			return CourseBookMessages.NO_INSTRUCTOR_INFO_ASSIGNED.toString();
		}
		ArrayList<String> courseNoList=null;
		if(instructorList!=null)
		{
			for(Instructor  instr : instructorList.getInstructorList())
			{
				if(instr.getIsArchived())
					continue;
				if(instr.getNetId().compareToIgnoreCase(userNetId) == 0)
				{
					if(courseNoList==null)
						courseNoList = new ArrayList<String>();
					courseNoList.add(instr.getInstructorForCourse());
				}
			}
		}
		if(courseNoList == null)
			return CourseBookMessages.NO_COURSE_ASSIGNED.toString();

		// check if that course info is already filled

		Books bookList= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation+"books.xml");
			if(existingFile.exists())
				bookList= (Books) jaxbUnmarshaller.unmarshal(existingFile);
		}
		catch(Exception e)
		{
			logger.warn("No courses found");
			e.printStackTrace();
		}

		if(bookList !=null)
		{
			for(Book book : bookList.getBookList())
			{
				if(book.getIsArchived())
					continue;
				if(courseNoList!=null && courseNoList.contains(book.getCourseNumber()))
					courseNoList.remove(book.getCourseNumber());
			}
		}
		if(courseNoList.isEmpty())
			return CourseBookMessages.COURSE_INFO_ALREADY_FILLED.toString();

		// if course are not filled return a string of all course numbers delimited by |
		StringBuffer sb = new StringBuffer();
		for(String courseNo : courseNoList){
			sb.append(courseNo).append("-");
		}
		sb.delete(sb.length()-1, sb.length());
		return sb.toString();
	}

	/**
	 * Function to get a list of all unassigned courses
	 * @return
	 */
	public ArrayList<Course> getAllUnAssignedCourses() {

		
		CourseList courseList= null;
		ArrayList<Course> validCourseList = new ArrayList<Course>();
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(CourseList.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"course.xml");
	    	if(!existingFile.exists())
	    		return null;
	    	courseList = (CourseList) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No courses found");
	    	e.printStackTrace();
	    }
		if(courseList==null)
			return null;
		else{
			for(Course item : courseList.getCourses())
				if(!item.getIsArchived())
					validCourseList.add(item);
			// now we have to remove the course that are already assigned
			//return validCourseList;
		}
		
		Instructors instructorList= null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Instructors.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
	    	File existingFile= new File(dbFilesLocation+"instructors.xml");
	    	if(existingFile.exists())
	    		instructorList = (Instructors) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	logger.warn("No existing instructor details");
	    	e.printStackTrace();
	    	System.out.println("Error : " + e.getMessage() +"\n"+ e.getStackTrace());
	    }
		
		ArrayList<String> assignedCourseList = new ArrayList<String>();
		if(instructorList!=null)
		{
			for(Instructor item : instructorList.getInstructorList())
			{
				if(!item.getIsArchived())
					assignedCourseList.add(item.getInstructorForCourse());
			}
		}
		ArrayList<Course> unAssignedCourse = new ArrayList<Course>(validCourseList);
		for(Course item : validCourseList)
		{
			if(assignedCourseList.contains(item.getCourseNumber()))
				unAssignedCourse.remove(item);
		}
		return unAssignedCourse;
	}

	/**
	 * Function to get email IDs of users for all the courses
	 * @return
	 */
	public String[] getUsersToEmail() 
	{
		ArrayList<Instructor> instructorList = getInstructorCourseAssignment(); 
		if(instructorList == null || instructorList.isEmpty())
			return null;
		ArrayList<Instructor> instructorToEmail = new ArrayList<Instructor>(instructorList);
		ArrayList<Book> unarchivedBooks = getAllBookDetails();
		ArrayList<String> courseNumList = null;
		
		for(Book book  : unarchivedBooks)
		{
			if(courseNumList == null)
				courseNumList = new ArrayList<String>();
			courseNumList.add(book.getCourseNumber());
		}
		
		if(courseNumList!=null && !courseNumList.isEmpty())
		{
			for(Instructor ins : instructorList)
			{
				if(courseNumList.contains(ins.getInstructorForCourse()))
					instructorToEmail.remove(ins);
			}
		}
		ArrayList<String> emailIds = new ArrayList<String>();
		for(Instructor ins : instructorList)
		{
			emailIds.add(ins.getNetId() + "@iastate123.edu");
		}
		return emailIds.toArray(new String[1]);
	}
}
