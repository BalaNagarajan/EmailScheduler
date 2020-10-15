package com.jcircle.email.batch.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service("emailService")
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private SpringTemplateEngine thymeleafTemplateEngine;

	/**
	 * Send simple message
	 * 
	 * @param to
	 * @param subject
	 * @param text
	 */
	public void sendSimpleMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("test@xyz.com");
		message.setTo("test@xyz.com");
		message.setSubject("Subject test");
		message.setText("SAMPLE TEST EMAIL");
		emailSender.send(message);

	}

	/**
	 * Send HTML message
	 * 
	 * @param to
	 * @param subject
	 * @param text
	 */
	public void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setFrom("test@xyz.com");
		helper.setTo("test@xyz.com");
		helper.setSubject("Subject test");
		helper.setText(htmlBody, true);
		emailSender.send(message);

	}

	public void sendMessageUsingThymeleafTemplate(String to, String subject) throws MessagingException {

		Context thymeleafContext = new Context();

		Map<String, Object> templateModel = new HashMap<>();
		templateModel.put("recipientName", "test@xyz.com");
		templateModel.put("text", "WELCOME EMAIL");
		templateModel.put("senderName", "test@xyz.com");

		thymeleafContext.setVariables(templateModel);

		String htmlBody = thymeleafTemplateEngine.process("jcircle-template.html", thymeleafContext);

		sendHtmlMessage(to, subject, htmlBody);
	}

}
