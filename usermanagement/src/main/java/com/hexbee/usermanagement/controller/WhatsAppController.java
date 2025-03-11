package com.hexbee.usermanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexbee.usermanagement.dto.WhatsAppRequest;
import com.hexbee.usermanagement.serviceIMPL.WhatsAppService;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {

    private final WhatsAppService whatsAppService;

    public WhatsAppController(WhatsAppService whatsAppService) {
        this.whatsAppService = whatsAppService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendWhatsAppNotification(@RequestBody WhatsAppRequest request) {
        try {
            String response = whatsAppService.sendWhatsAppMessage(request.getTo(), request.getMessage());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
