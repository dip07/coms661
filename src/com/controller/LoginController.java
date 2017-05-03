/**
 * 
 */
package com.controller;

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
import com.models.LoginForm;
import com.models.Roles.Role;

/**
 * @author dipanjankarmakar
 *
 */

@Controller
public class LoginController {
	
	Logger logger= Logger.getLogger(LoginController.class);
	
	@Autowired
	BookXmlDbDao xmlDbDao;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("login");
		model.addObject("message", "Inside Login Controller");
		modelObj.addAttribute("loginForm", new LoginForm());
		return model;
	}
	
	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(@ModelAttribute("loginForm") LoginForm loginForm,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		try{

			logger.debug("LoginForm >> " + loginForm.toString());
			Role roleForValidUser=xmlDbDao.getRoleForValidUser(loginForm.getNetId(),loginForm.getPassword());
			if(roleForValidUser == null)
			{
				// user not authorised
				ModelAndView model = new ModelAndView("login");
				model.addObject("errorMessage", "You are not authorised to use this system");
				modelObj.addAttribute("loginForm", new LoginForm());
				return model;
			}
			else
			{
				request.getSession().setAttribute("role", roleForValidUser.getRoleName());
				request.getSession().setAttribute("bookUserNetId", loginForm.getNetId());
				String userName=xmlDbDao.getUserName(loginForm.getNetId());
				if(userName!=null){
					request.getSession().setAttribute("bookUserName", userName);
				}
			}
			ModelAndView model = new ModelAndView("redirect:/welcome");
			//model.addObject("message", "from checkLogin function");
			return model;
		}catch(Exception e)
		{
			logger.error("Error in LoginController >> " + e.getStackTrace());
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("redirect:/");
		request.getSession().removeAttribute("bookUserName");
		request.getSession().removeAttribute("bookUserNetId");
		request.getSession().removeAttribute("role");
		return model;
	}

}
