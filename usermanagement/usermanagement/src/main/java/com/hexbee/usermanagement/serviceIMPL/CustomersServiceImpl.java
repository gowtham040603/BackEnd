package com.hexbee.usermanagement.serviceIMPL;import java.util.List;



import org.hibernate.validator.spi.scripting.ScriptEvaluatorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexbee.usermanagement.Repository.CustomersRepository;
import com.hexbee.usermanagement.dto.CustomersDTO;
import com.hexbee.usermanagement.entity.CustomersEntity;
import com.hexbee.usermanagement.service.CustomersService;

import jakarta.validation.Valid;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomersRepository customersrepository;
	
	@Override
	public CustomersEntity AddCustomer(@Valid CustomersDTO customersavedto) {
		CustomersEntity eco = new CustomersEntity();
		eco.setName(customersavedto.getName());
		eco.setEmail(customersavedto.getEmail());
		eco.setPhone(customersavedto.getPhone());
		eco.setAddress(customersavedto.getAddress());
		
		return customersrepository.save(eco);
	}

	@Override
    public List<CustomersEntity> getAllCustomers() {
        return customersrepository.findAll();

    }
	
	
	 @Override
	    public CustomersEntity updateCustomer(Integer id, CustomersDTO customerDTO) {
	        CustomersEntity existingCustomer = customersrepository.findById(id)
	                .orElseThrow(() -> new ScriptEvaluatorNotFoundException("Customer not found with id: " + id));
	        existingCustomer.setName(customerDTO.getName());
	        existingCustomer.setEmail(customerDTO.getEmail());
	        existingCustomer.setPhone(customerDTO.getPhone());
	        existingCustomer.setAddress(customerDTO.getAddress());
	        existingCustomer.setIsActive(customerDTO.getIsActive());

	        return customersrepository.save(existingCustomer);
   }

	 
	 @Override
	    public CustomersEntity getCustomerById (Integer id) {
		 CustomersEntity entity = customersrepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
	        return entity;
   }
	 
	 @Override
	    public void deleteCustomer(Integer id) {
	        CustomersEntity customer = customersrepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
	        customersrepository.delete(customer);
   }
}
