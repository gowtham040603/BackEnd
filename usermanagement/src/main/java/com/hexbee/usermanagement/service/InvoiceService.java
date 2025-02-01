package com.hexbee.usermanagement.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;


import com.hexbee.usermanagement.dto.InvoiceDTO;
import com.hexbee.usermanagement.entity.InvoiceEntity;


@Service
public interface InvoiceService {

	InvoiceEntity createInvoice(InvoiceDTO invoiceDTO);
	

	void deleteInvoice(Integer id);


	InvoiceEntity updateInvoice(Integer id, InvoiceDTO invoiceDTO);


	InvoiceEntity getInvoiceById(Integer id);


	List<InvoiceEntity> getAllInvoices();


	List<InvoiceEntity> getInvoicesByDateRange(LocalDateTime fromDate, LocalDateTime toDate);





}
