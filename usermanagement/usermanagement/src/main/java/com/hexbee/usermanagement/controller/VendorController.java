package com.hexbee.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexbee.usermanagement.dto.VendorDTO;
import com.hexbee.usermanagement.entity.VendorEntity;
import com.hexbee.usermanagement.service.VendorService;

import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

	@Autowired
    VendorService vendorService;

	@PostMapping
	public ResponseEntity<?> createVendor(@Valid @RequestBody VendorDTO vendorDTO) {
	    VendorEntity vendor = vendorService.createVendor(vendorDTO);
	    return ResponseEntity.ok(vendor);
	}


    @GetMapping
    public List<VendorEntity> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorEntity> getVendorById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(vendorService.getVendorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorEntity> updateVendor(@PathVariable ("id")  Long id,@Valid @RequestBody VendorDTO vendorDTO) {
        return ResponseEntity.ok(vendorService.updateVendor(id, vendorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok("Vendor deleted successfully.");
    }
    
}