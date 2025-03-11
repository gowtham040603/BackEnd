package com.hexbee.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.dto.NotificationRequest;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(NotificationRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getRecipient());
        message.setSubject(request.getSubject());
        
        // Construct email body
        String body = request.getData().get("message").toString();
        message.setText(body);
        
        mailSender.send(message);
        System.out.println("Email sent successfully to: " + request.getRecipient());
    }
}
