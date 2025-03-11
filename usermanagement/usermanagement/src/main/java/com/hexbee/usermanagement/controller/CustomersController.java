package com.hexbee.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexbee.usermanagement.dto.CustomersDTO;
import com.hexbee.usermanagement.entity.CustomersEntity;
import com.hexbee.usermanagement.service.CustomersService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customers")
public class CustomersController {

	@Autowired
	CustomersService customersservice;
	
	@PostMapping(path="/detail")
	public CustomersEntity savestudent(@Valid @RequestBody CustomersDTO customersavedto)
	{
		CustomersEntity cus = customersservice.AddCustomer(customersavedto);
	    return cus;
	
	}
	
    @GetMapping
    public List<CustomersEntity> getAllCustomers() {
      return customersservice.getAllCustomers();
    }
	
    @PutMapping("/{id}")
    public ResponseEntity<CustomersEntity> updateCustomer(@PathVariable ("id") Integer id, @Valid @RequestBody CustomersDTO customerDTO) {
        return ResponseEntity.ok(customersservice.updateCustomer(id, customerDTO));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomersEntity> getCustomerById(@PathVariable ("id")  Integer id) {
    	CustomersEntity custom = customersservice.getCustomerById(id);
        return ResponseEntity.ok(custom);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable  ("id") Integer id) {
        customersservice.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
