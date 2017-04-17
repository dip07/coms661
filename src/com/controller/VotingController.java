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

import com.dao.BookXmlDbDao;
import com.models.Vote;

@Controller
public class VotingController 
{
	@Autowired
	BookXmlDbDao xmlDbDao;
	
	Logger logger= Logger.getLogger(VotingController.class);

	@RequestMapping("/myVote")
	public ModelAndView myVote(@ModelAttribute("Topic") Vote vote , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside myVote");
		ModelAndView modelObj = new ModelAndView("vote");
		
		return modelObj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/voteAdmin")
	public ModelAndView voteAdmin(@ModelAttribute("Topic") Vote voteAdmin , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside myVoteAdmin");
		ModelAndView modelObj = new ModelAndView("voteAdmin");
		
		return modelObj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/newVote")
	public ModelAndView createVote(@ModelAttribute("Topic") Vote newVote , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside newVote");
		ModelAndView modelObj = new ModelAndView("newVote");
		
		return modelObj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
