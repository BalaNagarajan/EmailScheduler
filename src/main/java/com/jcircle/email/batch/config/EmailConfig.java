package com.jcircle.email.batch.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		//Set yahoo or gmail
		mailSender.setHost("smtp.mail.yahoo.com");
		mailSender.setPort(587);
		

		mailSender.setUsername("receipient@jcircle.com");
		mailSender.setPassword("ghgjghh");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		mailSender.setJavaMailProperties(props);
         
		return mailSender;
	}

}
