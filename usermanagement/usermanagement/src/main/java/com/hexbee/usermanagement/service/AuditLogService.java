package com.hexbee.usermanagement.service;

import java.util.List;

import com.hexbee.usermanagement.dto.AuditLogDTO;
import com.hexbee.usermanagement.entity.AuditLogEntity;




public interface AuditLogService {




    AuditLogEntity getLogsByUserId(Integer id);

	AuditLogEntity logAction(AuditLogDTO auditLogDTO);

	List<AuditLogEntity> getAllLogs();
}
