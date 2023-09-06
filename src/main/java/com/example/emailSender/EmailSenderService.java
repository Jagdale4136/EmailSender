package com.example.emailSender;

import java.io.File;
import java.nio.file.FileSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
     @Autowired
	private JavaMailSender mailSender;
	public void sendEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("jagdalek@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(subject);
		
		mailSender.send(message);
		System.out.println("Mail sent ......");
	}
	
	public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException {
		MimeMessage messageHelper=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(messageHelper, true);
		helper.setFrom("jagdalek@gmail.com");
		helper.setText(body);
		helper.setSubject(subject);
		helper.setTo(toEmail);
		  
		FileSystemResource resource=new FileSystemResource(new File(attachment));
		
		helper.addAttachment(resource.getFilename(), resource);
		mailSender.send(messageHelper);
		
		System.out.println("mail sent");
		
		
	}
}
