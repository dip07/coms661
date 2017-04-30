package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * @author dipanjankarmakar
 *
 */
@Service("adminEmail")
public class EmailAPI {
	
	@Autowired
	private MailSender isumail;
	
	public void adminReadyToSendEmail(String toAddress[], String ccAddress, String fromAddress, String subject, String msgBody) {
		 
		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setFrom(fromAddress);
		if(ccAddress!=null && !ccAddress.isEmpty())
			emailMsg.setCc(ccAddress);
		//emailMsg.setTo(toAddress);
		emailMsg.setTo(toAddress);
		emailMsg.setSubject(subject);
		emailMsg.setText(msgBody);
		isumail.send(emailMsg);
	}

}
