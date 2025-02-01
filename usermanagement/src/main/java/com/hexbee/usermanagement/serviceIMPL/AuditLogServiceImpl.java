package com.hexbee.usermanagement.serviceIMPL;

import com.hexbee.usermanagement.Repository.AuditLogRepository;
import com.hexbee.usermanagement.Repository.UserRepository;
import com.hexbee.usermanagement.dto.AuditLogDTO;
import com.hexbee.usermanagement.entity.AuditLogEntity;
import com.hexbee.usermanagement.entity.InvoiceItemEntity;
import com.hexbee.usermanagement.entity.UserEntity;

import com.hexbee.usermanagement.service.AuditLogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AuditLogServiceImpl implements AuditLogService {
     
    @Autowired
    private AuditLogRepository auditLogRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public AuditLogEntity logAction(AuditLogDTO auditLogDTO) {
    	
        UserEntity user = userRepository.findById(auditLogDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + auditLogDTO.getUserId()));

        
        AuditLogEntity auditLog = new AuditLogEntity();
        auditLog.setAction(auditLogDTO.getAction());
        auditLog.setDescription(auditLogDTO.getDescription());
        auditLog.setUser(user);

       return auditLogRepository.save(auditLog);
    }

    

    @Override
    public AuditLogEntity getLogsByUserId(Integer id) {
    	AuditLogEntity entity = auditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Audit logs not found with ID: " + id));
        return entity;
    }
    
    @Override
    public List<AuditLogEntity> getAllLogs() {
        return auditLogRepository.findAll();
    }

}



