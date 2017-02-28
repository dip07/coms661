package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.XmlDbDao;
import com.models.Book;

@Controller
public class HomeController 
{
	@Autowired
	XmlDbDao xmlDbDao;
	
	Logger logger= Logger.getLogger(HomeController.class);

	//@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from Controller  **********</div><br><br>";
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
		modelObj.addAttribute("bookForm", new Book());
		return model;
	}

	@RequestMapping("/getBookData")
	public ModelAndView getBookData(@ModelAttribute("bookForm") Book book , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside getBookData");
		ModelAndView modelObj = new ModelAndView("book");
		logger.warn("Got value from form :" + book.getBookName());
		modelObj.addObject("newMessage", "Got details");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		model.addAttribute("studentFormstudentForm", new Book());
		ArrayList<Book> bookObj=xmlDbDao.getBookDataFromDb(book);
		for(Book instance:bookObj)
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
}
