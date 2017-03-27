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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.models.Course;
import com.models.CourseList;

/**
 * @author dipanjankarmakar
 *
 */
@Controller
public class AdminController {
	
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
			jaxbMarshaller.marshal(course, System.out);
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

}
