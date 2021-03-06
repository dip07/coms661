package com.controller;

import java.util.ArrayList;
import java.util.UUID;

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
import com.dao.VoteXmlDbDao;
import com.models.Course;
import com.models.Vote;
import com.models.VoteForms;
import com.models.VoteForms.VoteForm;
/**
 * 
 * @author gbhatt
 *
 */
@Controller
public class VotingController 
{
	@Autowired
	VoteXmlDbDao voteDbDao;
	
	Logger logger= Logger.getLogger(VotingController.class);

	/**
	 * Used to create a vote
	 * @param vote : Object of class Vote
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/myVote")
	public ModelAndView myVote(@ModelAttribute("Topic") Vote vote , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside myVote");
		ModelAndView modelObj = new ModelAndView("getVotes");
		request.getSession().setAttribute("voteUserID", "gbhatt@iastate.edu");
		return modelObj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Admin's main view page
	 * @param voteAdmin : object of Class Vote
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
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
	
	
	/**
	 * Used to create new Vote details
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/newVote")
	public ModelAndView createVote(HttpServletRequest request,HttpServletResponse response,Model modelobject) throws Exception 
	{
		try{
		logger.warn("Inside newVote");
		ModelAndView model = new ModelAndView("newVoteView");
		modelobject.addAttribute("voteForm", new VoteForms.VoteForm());
		
		return model;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This will be used to save vote data
	 * @param newVoteForm : object of Class VoteFrom
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/saveVote")
	public ModelAndView saveVoteDetail(@ModelAttribute("voteForm") VoteForm newVoteForm , HttpServletRequest request,HttpServletResponse response,Model modelobject) throws Exception 
	{
		System.out.println("Data: "+newVoteForm.toString());
		ModelAndView model = new ModelAndView("redirect:/newVote");
		newVoteForm.setVoteID(UUID.randomUUID().toString());
		voteDbDao.saveAdminVoteData(newVoteForm);
		return model;
	}
	
	/**
	 * Used to get vote details
	 * @param newVoteForm : Object of Class VoteForms
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/getVotes")
	public ModelAndView getVoteDetail(@ModelAttribute("voteForm") VoteForms newVoteForm , HttpServletRequest request,HttpServletResponse response,Model modelobject) throws Exception 
	{
		try{
		logger.warn("Inside getVotes");
		ModelAndView model = new ModelAndView("newGetVotes");
		modelobject.addAttribute("voteForm", new VoteForms());
		voteDbDao.getAllVotes(newVoteForm);
		
		String []voteUUIDs=null;
		ArrayList<VoteForm> votes = new ArrayList<VoteForm>();
		votes = newVoteForm.getVoteFormList();
		int i=0;
		for(VoteForm v: votes){
			if(v.getParticipants().contains((CharSequence) request.getSession().getAttribute("voteUserID"))){
				voteUUIDs[i] = v.getVoteID();
				i++;
			}		
			System.out.println("YO-"+voteUUIDs[i]);
		}
		System.out.println();
		return model;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Get details of a user's vote
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/myVotingDetails")
	public ModelAndView myVoteData(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		logger.warn("Inside myVoteAdmin");
		ModelAndView modelObj = new ModelAndView("myVotingDetails");
		return modelObj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
}
