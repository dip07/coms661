/**
 * 
 */
package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
import com.models.Course;
import com.models.CourseList;
import com.models.Instructors.Instructor;

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
	
	@RequestMapping("/viewAllCourse")
	public ModelAndView viewAllCourse(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("viewAllCourseScreen");
		ArrayList<Course> courseList= xmlDbDao.getAllCourses();
		modelObj.addAttribute("courseList", courseList);
		return model;
	}
	@RequestMapping("/saveCourse")
	public ModelAndView saveCourse(HttpServletRequest request,HttpServletResponse response, Model modelObj,@ModelAttribute("courseForm") Course course) throws Exception {

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
	    
		courseList.getCourses().add(course);
		try{
			File file = new File("/Users/dipanjankarmakar/Documents/Isu Google Drive/Isu Studies Google Drive/4th Sem/661/course.xml");
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(courseList, file);
			jaxbMarshaller.marshal(courseList, System.out);
			System.out.println(file.getAbsoluteFile()+" >> " + file.exists());
		}
		catch(Exception e)
		{
			logger.error("Exception while saving courses : " + e.getStackTrace());
			e.printStackTrace();
		}
		
		ModelAndView model = new ModelAndView("editCourse");
		modelObj.addAttribute("courseForm", new Course());
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
		ArrayList<Instructor> instructorList= xmlDbDao.getInstructorCourseAssignment();
		if(instructorList!=null)
			modelObj.addAttribute("instructorAssignment", instructorList);
		else
			modelObj.addAttribute("noData", true);
		logger.debug("Inside adminHome function");
		return model;
	}
	
	@RequestMapping("/editInstructorAssignment")
	public ModelAndView editInstructorAssignment(@RequestParam(value="net_id") Integer net_id,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("enterInstrCoursAssign");
		ArrayList<Course> courseList= xmlDbDao.getAllCourses();
		if(courseList!=null)	
			modelObj.addAttribute("courseList",courseList);
		if(net_id==null)
		{
			modelObj.addAttribute("instructorForm", new Instructor());
		}
		else
		{
			Instructor instructorObj= xmlDbDao.getInstructorCourseAssignment(net_id);
			if(instructorObj!=null)
				modelObj.addAttribute("instructorForm", instructorObj);
			else
				modelObj.addAttribute("instructorForm", new Instructor());
				
		}
		logger.debug("Inside adminHome function");
		return model;
	}
	
	

}
