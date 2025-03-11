package com.hexbee.usermanagement.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexbee.usermanagement.entity.VendorEntity;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Long> {
	
    Optional<VendorEntity> findByvendorCode(String code);

	List<VendorEntity> findAll();

	Optional<VendorEntity> findById(Long id);


	Optional<VendorEntity> findByEmail(String emailId);

	

	
    
}