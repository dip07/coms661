/**
 * 
 */
package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.BookXmlDbDao;
import com.models.BookOld;
import com.models.Course;
import com.models.CourseList;
import com.models.Instructors.Instructor;
import com.models.Users.User;

/**
 * @author dipanjankarmakar
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	BookXmlDbDao xmlDbDao;
	
	Logger logger= Logger.getLogger(AdminController.class);
	
	@RequestMapping("/adminHome")
	public ModelAndView adminHome(HttpServletRequest request,HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("adminHome");
		logger.debug("Inside adminHome function");
		model.addObject("message", "Custom message from Admin Controller");
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
		ArrayList<Course> courseList= xmlDbDao.getAllCourses();
		if(courseList!=null)
			modelObj.addAttribute("courseList", courseList);
		else
			modelObj.addAttribute("noData", true);
		return model;
	}
	@RequestMapping("/saveCourse")
	public ModelAndView saveCourse(HttpServletRequest request,HttpServletResponse response, Model modelObj,@ModelAttribute("courseForm") Course course) throws Exception {

		xmlDbDao.saveCourse(course);
		ModelAndView model = new ModelAndView("redirect:/viewAllCourse");
		return model;
	}
	
	@RequestMapping("/adminScreen")
	public ModelAndView adminScreen(HttpServletRequest request,HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("adminScreen");
		logger.debug("Inside adminHome function");
		return model;
	}
	
	@RequestMapping("/viewInstructorDetails")
	public ModelAndView enterEditInstructorDetails(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("viewInstrCoursAssign");
		ArrayList<Course> courseList= xmlDbDao.getAllCourses();
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
		logger.debug("Inside adminHome function");
		return model;
	}
	
	@RequestMapping("/editInstructorAssignment")
	public ModelAndView editInstructorAssignment(@RequestParam(value="course_id", required = false) String course_id,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("enterInstrCoursAssign");
		try{
		
		ArrayList<Course> courseList= xmlDbDao.getAllCourses();
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
		logger.debug("Inside adminHome function");
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
		logger.debug("Inside adminHome function");
		return model;
	}

}
