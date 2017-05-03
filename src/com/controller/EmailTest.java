/**
 * 
 */
package com.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.service.EmailAPI;

/**
 * @author dipanjankarmakar
 *
 */
public class EmailTest {
	
	@SuppressWarnings("resource")
	public static void main(String args[]) {
 
		// Spring Bean file you specified in /src/main/resources folder
		String emailConfFile = "/WebContent/WEB-INF/dispatcher-servlet.xml";
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext(emailConfFile);
 
		// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
		EmailAPI emailAPI = (EmailAPI) context.getBean("adminEmail");
		String toAddr[] = new String[]{"dipanjan@iastate.edu"};
		String fromAddr = "dipanjan.online@gmail.com";
 
		// email subject
		String subject = "Hey.. This email sent by Dipanjan' Spring MVC App";
 
		// email body
		String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Dipanjan Email Admin";
		emailAPI.adminReadyToSendEmail(toAddr, null ,fromAddr, subject, body);
	}

}
