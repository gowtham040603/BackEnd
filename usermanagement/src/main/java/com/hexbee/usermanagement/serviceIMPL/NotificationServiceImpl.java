package com.hexbee.usermanagement.serviceIMPL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Map;

import com.hexbee.usermanagement.dto.NotificationRequest;
import com.hexbee.usermanagement.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;  // ✅ Inject Thymeleaf Template Engine

    @Override
    public void sendNotification(NotificationRequest request) {
        switch (request.getType()) {
            case EMAIL:
                sendEmailNotification(request);
                break;
            case SMS:
                sendSmsNotification(request);
                break;
            case WHATSAPP:
                sendWhatsappNotification(request);
                break;
            case PUSH:
                sendPushNotification(request);
                break;
            default:
                log.warn("Unsupported notification type: {}", request.getType());
        }
    }
    private void sendEmailNotification(NotificationRequest request) {
        log.info("Sending EMAIL to {} with subject: {}", request.getRecipient(), request.getSubject());

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("vkgowtham68@gmail.com");
            helper.setTo(request.getRecipient());
            helper.setSubject(request.getSubject());

            // ✅ Correctly get templateType from the request object
            String templateType = request.getTemplateType();
            String templateName;

            if ("ORDER_CONFIRMATION".equalsIgnoreCase(templateType)) {
                templateName = "emails/order/order-confirmation-mail";
            } else if ("WELCOME".equalsIgnoreCase(templateType)) {
                templateName = "emails/welcome/welcome-mail";
            } else {
                log.error("Unknown email template type: {}", templateType);
                return;
            }

            // ✅ Set Thymeleaf Context
            Context context = new Context();
            context.setVariables(request.getData());

            // ✅ Process template and send email
            String htmlContent = templateEngine.process(templateName, context);
            helper.setText(htmlContent, true);
            mailSender.send(message);
            log.info("Email sent successfully to {}", request.getRecipient());

        } catch (MessagingException e) {
            log.error("Failed to send email to {}: {}", request.getRecipient(), e.getMessage());
        }
    }



    private void sendSmsNotification(NotificationRequest request) {
        log.info("Sending SMS to {}", request.getRecipient());
    }

    private void sendWhatsappNotification(NotificationRequest request) {
        log.info("Sending WhatsApp message to {}", request.getRecipient());
    }

    private void sendPushNotification(NotificationRequest request) {
        log.info("Sending Push Notification to {}", request.getRecipient());
    }
}