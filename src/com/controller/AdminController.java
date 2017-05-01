/**
 * 
 */
package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.BookXmlDbDao;
import com.models.Course;
import com.models.Instructors.Instructor;
import com.models.Users.User;
import com.service.EmailAPI;

import constants.CourseBookMessages;

/**
 * @author dipanjankarmakar
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	BookXmlDbDao xmlDbDao;
	
	@Autowired
	EmailAPI emailAPI;
	
	@Value("${server.url}")
	String serverUrl;
	
	@Value("${emailText}")
	String emailText;
	
	@Value("${from.address}")
	String fromAddress;
	
	@Autowired
	protected ApplicationContext context;
	
	Logger logger= Logger.getLogger(AdminController.class);
	
	@RequestMapping("/adminHome")
	public ModelAndView adminHome(HttpServletRequest request,HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("adminHome");
		return model;
	}
	@RequestMapping("/enterUpdateCourse")
	public ModelAndView enterUpdateCourse(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("editCourse");
		modelObj.addAttribute("courseForm", new Course());
		return model;
	}
	@RequestMapping("/editCourse")
	public ModelAndView editCourse(@ModelAttribute("course_number")String course_number,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("editCourse");
		Course course= xmlDbDao.getCourseDetails(course_number);
		modelObj.addAttribute("courseForm", course);
		return model;
	}
	
	@RequestMapping("/viewAllCourse")
	public ModelAndView viewAllCourse(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("viewAllCourseScreen");
		ArrayList<Course> courseList= xmlDbDao.getAllUnarchivedCourses();
		if(courseList!=null)
			modelObj.addAttribute("courseList", courseList);
		else
			modelObj.addAttribute("noData", true);
		return model;
	}
	@RequestMapping("/saveCourse")
	public ModelAndView saveCourse(HttpServletRequest request,HttpServletResponse response, Model modelObj,@ModelAttribute("courseForm") Course course) throws Exception {

		ModelAndView model = new ModelAndView("redirect:/viewAllCourse");
		String status = xmlDbDao.saveCourse(course,false);
		modelObj.addAttribute("status", status);
		if(status.equalsIgnoreCase(CourseBookMessages.COURSE_INFO_ALREADY_FILLED.toString()) || status.equalsIgnoreCase(CourseBookMessages.FAILED_TRANSACTION.toString()))
		{
			modelObj.addAttribute("courseForm", new Course());
			return new ModelAndView("editCourse");
		}
		return model;
	}
	
	@RequestMapping("/saveEditedCourse")
	public ModelAndView saveEditedCourse(HttpServletRequest request,HttpServletResponse response, Model modelObj,@ModelAttribute("courseForm") Course course) throws Exception {

		ModelAndView model = new ModelAndView("redirect:/viewAllCourse");
		String status = xmlDbDao.saveCourse(course, true);
		modelObj.addAttribute("status", status);
		if(status.equalsIgnoreCase(CourseBookMessages.COURSE_INFO_ALREADY_FILLED.toString()) || status.equalsIgnoreCase(CourseBookMessages.FAILED_TRANSACTION.toString()))
		{
			modelObj.addAttribute("courseForm", new Course());
			return new ModelAndView("editCourse");
		}
		return model;
	}
	
	@RequestMapping("/adminScreen")
	public ModelAndView adminScreen(HttpServletRequest request,HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("adminScreen");
		return model;
	}
	
	@RequestMapping("/viewInstructorDetails")
	public ModelAndView enterEditInstructorDetails(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("viewInstrCoursAssign");
		ArrayList<Course> courseList= xmlDbDao.getAllUnarchivedCourses();
		Map<String,String> courseNumNameMap=new HashMap<String,String>();
		for(Course course : courseList)
		{
			courseNumNameMap.put(course.getCourseNumber(), course.getCourseName());
		}
		ArrayList<Instructor> instructorList= xmlDbDao.getInstructorCourseAssignment();
		if(instructorList != null)
		{
			for(Instructor ins : instructorList)
			{
				ins.setInstructorForCourse(ins.getInstructorForCourse() + "-"+ courseNumNameMap.get(ins.getInstructorForCourse()));
			}
		}
		if(instructorList!=null)
			modelObj.addAttribute("instructorAssignment", instructorList);
		else
			modelObj.addAttribute("noData", true);
		return model;
	}
	
	@RequestMapping("/editInstructorAssignment")
	public ModelAndView editInstructorAssignment(@RequestParam(value="course_id", required = false) String course_id,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("enterInstrCoursAssign");
		try{

			ArrayList<Course> courseList= xmlDbDao.getAllUnAssignedCourses();
			Map<String,String> courseNameList = new HashMap<String,String>();
			for(Course course: courseList)
				courseNameList.put(course.getCourseNumber(),course.getCourseName());
			if(!courseNameList.isEmpty())	
				modelObj.addAttribute("courseNameList",courseNameList);
			//modelObj.addAttribute("courseList", courseList);

			ArrayList<User> userList= xmlDbDao.getAllUsers();
			ArrayList<String> userNameList = new ArrayList<String>();
			for(User user: userList)
				userNameList.add(user.getName());
			if(!userNameList.isEmpty())	
				modelObj.addAttribute("userNameList",userNameList);


			if(course_id==null)
			{
				if(courseNameList.isEmpty())
					modelObj.addAttribute("status", CourseBookMessages.ALL_COURSE_ASSIGNED.toString());
				modelObj.addAttribute("instructorForm", new Instructor());
			}
			else
			{
				Instructor instructorObj= xmlDbDao.getInstructorCourseAssignment(course_id);
				if(instructorObj!=null)
					modelObj.addAttribute("instructorForm", instructorObj);
				else
					modelObj.addAttribute("instructorForm", new Instructor());

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping("/saveEditInstructor")
	public ModelAndView saveEditInstructor(@ModelAttribute("instructorForm") Instructor instructorForm,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("redirect:/viewInstructorDetails");
		Boolean isSaved= xmlDbDao.saveEditInstructorData(instructorForm);
		logger.debug("Inside saveEditInstructor. Value of isSaved is : " + isSaved);
		return model;
	}
	
	@RequestMapping("/sendReminderEmail")
	public ModelAndView sendReminderEmail(HttpServletRequest request,HttpServletResponse response, Model modelObj, RedirectAttributes redir) throws Exception {

		ModelAndView model = new ModelAndView("redirect:/adminScreen");
		/*
		String toAddr = "dipanjan@iastate.edu";
		String fromAddr = "dipanjan@iastate.edu";
		// email subject
		String subject = "Reminder: Please fill the course book in the system";
		// email body
		String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Dipanjan Email Admin";
		emailAPI.adminReadyToSendEmail(toAddr, null ,fromAddr, subject, body);
		*/
		
		boolean emailSent = true;
		String netIdToEmail[] = null;
		try{
		netIdToEmail = xmlDbDao.getUsersToEmail();
		String emailMessage = context.getMessage("email.text", new Object[] {serverUrl}, StringUtils.parseLocaleString("en")); 
		String emailSubject = context.getMessage("email.subject", null, StringUtils.parseLocaleString("en")); 
		logger.debug("Email text : " + emailMessage);
			emailAPI.adminReadyToSendEmail(netIdToEmail, null ,fromAddress, emailSubject, emailMessage);
		}
		catch(Exception e)
		{
			logger.error("Error while sending reminder email " + e.getMessage() , e);
			emailSent = false;
		}
		if(netIdToEmail!=null && netIdToEmail.length > 0 && emailSent)
			redir.addFlashAttribute("status", "Email sent successfully");
		return model;
	}

}
