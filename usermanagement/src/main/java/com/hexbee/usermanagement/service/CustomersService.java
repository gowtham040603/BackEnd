package com.hexbee.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.dto.CustomersDTO;
import com.hexbee.usermanagement.entity.CustomersEntity;
import jakarta.validation.Valid;

@Service
public interface CustomersService {

	 public CustomersEntity AddCustomer(@Valid CustomersDTO customersavedto);

	 public List<CustomersEntity> getAllCustomers();

	 public CustomersEntity updateCustomer(Integer id, @Valid CustomersDTO customerDTO);

	 public CustomersEntity getCustomerById(Integer id);

	 public void deleteCustomer(Integer id);

	
	
	



}
