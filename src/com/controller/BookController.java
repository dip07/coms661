package com.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.BookXmlDbDao;
import com.models.BookOld;
import com.models.Books.Book;
import com.models.Books;
import com.models.Course;
import com.models.CourseList;

@Controller
public class BookController 
{
	@Autowired
	BookXmlDbDao xmlDbDao;
	
	Logger logger= Logger.getLogger(BookController.class);

	//@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'><h3>Hello Message</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	@RequestMapping("/welcome")
	public ModelAndView hello(HttpServletRequest request,HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("welcome");
		model.addObject("message", "Custom message from Controller");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		return model;
	}

	@RequestMapping("/fetchBook")
	public ModelAndView fetchBook(HttpServletRequest request,HttpServletResponse response,Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("book");
		model.addObject("message", "From fetchBook function");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		modelObj.addAttribute("bookForm", new BookOld());
		return model;
	}

	@RequestMapping("/getBookData")
	public ModelAndView getBookData(@ModelAttribute("bookForm") BookOld book , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside getBookData");
		ModelAndView modelObj = new ModelAndView("book");
		logger.warn("Got value from form :" + book.getBookName());
		modelObj.addObject("newMessage", "Got details");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		model.addAttribute("studentFormstudentForm", new BookOld());
		ArrayList<BookOld> bookObj=xmlDbDao.getBookDataFromDb(book);
		for(BookOld instance:bookObj)
			logger.warn(instance);
		model.addAttribute("isDataPresent", true);
		model.addAttribute("bookObj", bookObj);
		return modelObj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/viewEditBookData")
	public ModelAndView enterBookData(@ModelAttribute("bookForm") BookOld book , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside getBookData");
		ModelAndView modelObj = new ModelAndView("book");
		logger.warn("Got value from form :" + book.getBookName());
		modelObj.addObject("newMessage", "Got details");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		model.addAttribute("studentFormstudentForm", new BookOld());
		ArrayList<BookOld> bookObj=xmlDbDao.getBookDataFromDb(book);
		for(BookOld instance:bookObj)
			logger.warn(instance);
		model.addAttribute("isDataPresent", true);
		model.addAttribute("bookObj", bookObj);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(CourseList.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	    CourseList courseList= null;
	    try{
	    	File existingFile= new File("/Users/dipanjankarmakar/Documents/Isu Google Drive/Isu Studies Google Drive/4th Sem/661/course.xml");
	    	courseList = (CourseList) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	courseList= new CourseList();
	    	courseList.setCourses(new ArrayList<Course>());
	    	e.printStackTrace();
	    }
	    model.addAttribute("courseList", courseList);
		//return modelObj;
		return new ModelAndView("editBookData");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/getBook")
	public ModelAndView getBookInformation(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("enterBookPage");
		model.addObject("message", "Custom message from Controller");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		Books.Book bookObj= new Books.Book();
		bookObj.setCourseName("Introduction to Algo");
		bookObj.setInstructorName("Gaurav Bhatt");
		bookObj.setSession("Spring");
		bookObj.setYear(2017);
		modelObj.addAttribute("bookForm", bookObj);
		return model;
	}
	
	@RequestMapping("/saveBook")
	public ModelAndView saveBookInforation(@ModelAttribute("bookForm") Books.Book book,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("enterBookPage");
		model.addObject("message", "Custom message from Controller");
		logger.warn("Warn Inside the logger");
		logger.warn("Book information > " + book.toString());
		return model;
	}
}
