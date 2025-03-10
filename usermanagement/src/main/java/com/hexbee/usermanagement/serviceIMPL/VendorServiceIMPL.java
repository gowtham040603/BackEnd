package com.hexbee.usermanagement.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.Repository.VendorRepository;
import com.hexbee.usermanagement.dto.VendorDTO;

import com.hexbee.usermanagement.entity.VendorEntity;
import com.hexbee.usermanagement.exceptionHandler.EmailAlreadyExistsException;
import com.hexbee.usermanagement.service.VendorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Service
@Transactional

public class VendorServiceIMPL implements VendorService {
    
	
	@Autowired
    VendorRepository vendorRepository;

	@Override
	public VendorEntity createVendor(@Valid VendorDTO vendorDTO) {
		
	    Optional<VendorEntity> existingUser = vendorRepository.findByEmail(vendorDTO.getEmail());
	    if (existingUser.isPresent()) {
	        throw new EmailAlreadyExistsException("Email already exists: " + vendorDTO.getEmail());
	    }
		
        VendorEntity vendor =  new VendorEntity();
        
           vendor.setVendorName(vendorDTO.getVendorName());
           vendor.setVendorCode(vendorDTO.getVendorCode());
           vendor.setGstNumber(vendorDTO.getGstNumber());
           vendor.setContactPerson(vendorDTO.getContactPerson());
           vendor.setPhoneNumber(vendorDTO.getPhoneNumber());
           vendor.setEmail(vendorDTO.getEmail());
           vendor.setAddress(vendorDTO.getAddress());
              

        return vendorRepository.save(vendor);
    }

    @Override
    public List<VendorEntity> getAllVendors() {
        return vendorRepository.findAll();
     
    }

    @Override
    public VendorEntity getVendorById(Long id) {
    	VendorEntity entity = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + id));
        return entity;
    }

    @Override
    public VendorEntity updateVendor(Long id, VendorDTO vendorDTO) {
    	VendorEntity editVendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + id));

    	editVendor.setVendorName(vendorDTO.getVendorName());
    	editVendor.setVendorCode(vendorDTO.getVendorCode());
    	editVendor.setGstNumber(vendorDTO.getGstNumber());
    	editVendor.setContactPerson(vendorDTO.getContactPerson());
    	editVendor.setPhoneNumber(vendorDTO.getPhoneNumber());
    	editVendor.setEmail(vendorDTO.getEmail());
    	editVendor.setAddress(vendorDTO.getAddress());

    	return vendorRepository.save(editVendor);
   
    }

    @Override
    public void deleteVendor(Long id) {
        if (!vendorRepository.existsById(id)) {
            throw new RuntimeException("Vendor not found with ID: " + id);
        }
        vendorRepository.deleteById(id);
    }

   

}