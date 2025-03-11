package com.hexbee.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.dto.VendorDTO;
import com.hexbee.usermanagement.entity.VendorEntity;

@Service
public interface VendorService {
	
	 public VendorEntity createVendor(VendorDTO vendorDTO);
    
	 public List<VendorEntity> getAllVendors();
    
	 public VendorEntity getVendorById(Long id);
    
	 public VendorEntity updateVendor(Long id, VendorDTO vendorDTO);
    
	 public void deleteVendor(Long id);
    
 }