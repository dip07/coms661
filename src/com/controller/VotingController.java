/*package com.controller;

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
import com.models.Vote;

@Controller
public class VotingController 
{
	@Autowired
	XmlDbDao xmlDbDao;
	
	Logger logger= Logger.getLogger(VotingController.class);

	//@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "********* This is voting Controller, takes care of everything related to voting  **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	@RequestMapping("/welcome")
	public ModelAndView vhello(HttpServletRequest request,HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("welcome");
		model.addObject("message", "Custom message from Controller");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		return model;
	}

	@RequestMapping("/fetchBook")
	public ModelAndView voteTopic(HttpServletRequest request,HttpServletResponse response,Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("vote");
		model.addObject("message", "From fetchBook function");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		modelObj.addAttribute("bookForm", new Book());
		return model;
	}

	@RequestMapping("/myVote")
	public ModelAndView myVote(@ModelAttribute("Topic") Vote vote , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside myVote");
		ModelAndView modelObj = new ModelAndView("vote");
		
		Need some re-factoring before adding the code to git. Giving me compilation errors
		
		return modelObj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
*/