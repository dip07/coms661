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
import com.dao.JDBCDao;
import com.models.Student;

@Controller
public class HomeController 
{
	@Autowired
	JDBCDao jdbcDao;
	
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

	@RequestMapping("/fetchStudent")
	public ModelAndView fetchStudent(HttpServletRequest request,HttpServletResponse response,Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("student");
		model.addObject("message", "From fetchStudent function");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		modelObj.addAttribute("studentForm", new Student());

		return model;
	}

	@RequestMapping("/getStudentData")
	public ModelAndView getStudentData(@ModelAttribute("studentForm") Student student , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {

		ModelAndView modelObj = new ModelAndView("student");
		logger.warn("Got value from form :" + student.getFirst_name());
		modelObj.addObject("newMessage", "Got details");
		logger.debug("Debug Inside the logger");
		logger.warn("Warn Inside the logger");
		model.addAttribute("studentFormstudentForm", new Student());
		ArrayList<Student> studentObj=jdbcDao.getStudentDataFromDb(student);
		for(Student instance:studentObj)
			logger.warn(instance);
		model.addAttribute("isDataPresent", true);
		model.addAttribute("student", studentObj);
		return modelObj;
	}
}
