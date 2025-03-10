package com.hexbee.usermanagement.serviceIMPL;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhatsAppService {
    
    private static final Logger log = LoggerFactory.getLogger(WhatsAppService.class);

    @Value("${whatsapp.api.url}")
    private String apiUrl;

    @Value("${whatsapp.api.token}")
    private String accessToken;
    
    public String sendWhatsAppMessage(String recipient, String message) {
        log.info("Sending WhatsApp message to: {}", recipient);

        Map<String, Object> textMessage = new HashMap<>();
        textMessage.put("body", message);

        Map<String, Object> payload = new HashMap<>();
        payload.put("messaging_product", "whatsapp");
        payload.put("to", recipient);
        payload.put("type", "text");
        payload.put("text", textMessage);


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("Content-Type", "application/json");

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                log.info("WhatsApp message sent successfully to {}", recipient);
                return "WhatsApp message sent successfully!";
            } else {
                log.error("Failed to send WhatsApp message. Response: {}", response.getBody());
                throw new RuntimeException("Failed to send WhatsApp message.");
            }
        } catch (Exception e) {
            log.error("Error sending WhatsApp message: {}", e.getMessage());
            throw new RuntimeException("Error sending WhatsApp message.", e);
        }
    }

}
