package com.hexbee.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.dto.CustomersDTO;
import com.hexbee.usermanagement.entity.CustomersEntity;
import jakarta.validation.Valid;

@Service
public interface CustomersService {

	CustomersEntity AddCustomer(@Valid CustomersDTO customersavedto);

	List<CustomersEntity> getAllCustomers();

	CustomersEntity updateCustomer(Integer id, @Valid CustomersDTO customerDTO);

	CustomersEntity getCustomerById(Integer id);

	void deleteCustomer(Integer id);

	
	
	



}
