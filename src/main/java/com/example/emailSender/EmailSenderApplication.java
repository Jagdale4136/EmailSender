package com.example.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class EmailSenderApplication {
	@Autowired
    private EmailSenderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}
   
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		//service.sendEmail("jagdalekiran572@gmail.com", "This is email body", "Subject part check");
		
		service.sendEmailWithAttachment("SachinMore7121@gmail.com", "this is trial email for  body with attachment ", "this Email has attachment", "C:\\Users\\Kiran Jagdale\\Downloads\\car2.jpg");
	}
}
