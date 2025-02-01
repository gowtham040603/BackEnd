package com.hexbee.usermanagement.serviceIMPL;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.Repository.CustomersRepository;
import com.hexbee.usermanagement.Repository.InvoiceRepository;
import com.hexbee.usermanagement.Repository.UserRepository;
import com.hexbee.usermanagement.dto.InvoiceDTO;
import com.hexbee.usermanagement.entity.CustomersEntity;
import com.hexbee.usermanagement.entity.InvoiceEntity;
import com.hexbee.usermanagement.entity.UserEntity;
import com.hexbee.usermanagement.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
    private InvoiceRepository invoiceRepository;
	
	@Autowired
    private UserRepository userRepository;

	@Autowired
	CustomersRepository customersrepository;
	
	@Override
    public InvoiceEntity createInvoice(InvoiceDTO invoiceDTO) {
        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
        invoice.setTotalAmount(invoiceDTO.getTotalAmount());
        invoice.setGstAmount(invoiceDTO.getGstAmount());
        invoice.setFinalAmount(invoiceDTO.getFinalAmount());
        invoice.setPaidAmount(invoiceDTO.getPaidAmount());
        invoice.setBalanceAmount(invoiceDTO.getBalanceAmount());
        invoice.setDiscount(invoiceDTO.getDiscount());
        invoice.setIsActive(invoiceDTO.getIsActive());
        
        UserEntity createdBy = userRepository.findById(invoiceDTO.getCreatedBy())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + invoiceDTO.getCreatedBy()));
        invoice.setCreatedBy(createdBy);
        
        CustomersEntity customerId = customersrepository.findById(invoiceDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("customer not found with ID: " + invoiceDTO.getCustomerId()));
        invoice.setCustomerId(customerId);
        
        
        return invoiceRepository.save(invoice);
	}
        
   

    @Override
    public InvoiceEntity updateInvoice(Integer id, InvoiceDTO invoiceDTO) {
        Optional<InvoiceEntity> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isEmpty()) {
            throw new RuntimeException("Invoice not found with id " + id);
        }

        InvoiceEntity invoiceEntity = optionalInvoice.get();
        invoiceEntity.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
     
        invoiceEntity.setTotalAmount(invoiceDTO.getTotalAmount());
        invoiceEntity.setGstAmount(invoiceDTO.getGstAmount());
        invoiceEntity.setFinalAmount(invoiceDTO.getFinalAmount());
        invoiceEntity.setPaidAmount(invoiceDTO.getPaidAmount());
        invoiceEntity.setBalanceAmount(invoiceDTO.getBalanceAmount());
        invoiceEntity.setDiscount(invoiceDTO.getDiscount());
        invoiceEntity.setIsActive(invoiceDTO.getIsActive());
        invoiceEntity.setUpdatedAt(LocalDateTime.now());

        InvoiceEntity updatedInvoice = invoiceRepository.save(invoiceEntity);
        return updatedInvoice;
    }

    @Override
    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public InvoiceEntity getInvoiceById(Integer id) {
        InvoiceEntity invoiceEntity = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id " + id));
        return invoiceEntity;
    }

	@Override
	public java.util.List<InvoiceEntity> getAllInvoices() {
	       return invoiceRepository.findAll();
	}



	@Override
	public List<InvoiceEntity> getInvoicesByDateRange(LocalDateTime fromDate, LocalDateTime toDate) {

		return invoiceRepository.findByCreatedAtBetween(fromDate,toDate);
	}
	
	
 
	
}
