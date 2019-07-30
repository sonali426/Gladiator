package com.lti.spring.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SimpleMailController {
    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/sendMail")
    public String sendMail() {
        MimeMessage message = sender.createMimeMessage();
        
        System.out.println("checking");
        
        Integer otp = new Random().nextInt(10000);
        String body = "Greetings!\nYour OTP is " + otp;

        try {
        	MimeMessageHelper helper = new MimeMessageHelper(message, true);
        	helper.setFrom("gaemprojectlti@outlook.com");
            helper.setTo("sonali.singh@lntinfotech.com");
            helper.setText(body, true);
            helper.setSubject("Online Shopping OTP");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "errorPage";
        }
        sender.send(message);
        return "home";
    }



    @RequestMapping("/sendMailAtt")
    public String sendMailAttachment() throws MessagingException {
    	MimeMessage message = sender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(message,true);
    	try {
    		helper.setTo("ashwin.arora2@live.com");
    		helper.setText("Greetings :)\n Please find the attached docuemnt for your reference.");
    		helper.setSubject("Mail From Spring Boot");
    		//ClassPathResource file = new ClassPathResource("document.PNG");
    		//helper.addAttachment("document.PNG", file);
    	} catch (MessagingException e) {
    		e.printStackTrace();
    		return "Error while sending mail ..";
    	}
    	sender.send(message);
    	return "Mail Sent Success!";
    }

}