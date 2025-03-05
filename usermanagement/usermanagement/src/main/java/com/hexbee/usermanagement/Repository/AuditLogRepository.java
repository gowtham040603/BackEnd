package com.hexbee.usermanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexbee.usermanagement.entity.AuditLogEntity;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLogEntity, Integer> {

    List<AuditLogEntity> findByUserId(Integer userId); // Fetch logs by user ID
}