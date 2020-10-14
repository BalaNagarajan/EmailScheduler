package com.jcircle.email.batch.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xyz@jcircle.com");
		message.setTo("receipient.com");
		message.setSubject("Subject test");
		message.setText("SAMPLE TEST EMAIL");
		emailSender.send(message);

	}
}
