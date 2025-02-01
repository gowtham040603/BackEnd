package com.hexbee.usermanagement.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexbee.usermanagement.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {

	List<InvoiceEntity> findByCreatedAtBetween(LocalDateTime fromDate, LocalDateTime toDate);
	
}
