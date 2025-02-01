package com.hexbee.usermanagement.controller;

import com.hexbee.usermanagement.dto.AuditLogDTO;
import com.hexbee.usermanagement.entity.AuditLogEntity;

import com.hexbee.usermanagement.service.AuditLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {
	
    @Autowired
    AuditLogService auditLogService;

   

	 @PostMapping
     public ResponseEntity<AuditLogEntity> createAuditLogs(@RequestBody AuditLogDTO auditLogDTO) {
	   AuditLogEntity createdItem = auditLogService.logAction(auditLogDTO);
	        return ResponseEntity.ok(createdItem);
     }
	 
     @GetMapping
     public List<AuditLogEntity> getAllLogs() {
        return auditLogService.getAllLogs();
     }

     
     @GetMapping("/{id}")
	 public ResponseEntity<AuditLogEntity> getLogsByUserId(@PathVariable("id") Integer id) {
        AuditLogEntity item = auditLogService.getLogsByUserId(id);
	        return ResponseEntity.ok(item);
     }
     
}

