package com.hexbee.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexbee.usermanagement.entity.InvoiceItemEntity;
@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItemEntity, Integer>{
	
	

}
