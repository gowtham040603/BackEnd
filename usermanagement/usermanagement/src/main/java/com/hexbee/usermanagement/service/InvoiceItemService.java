package com.hexbee.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.dto.InvoiceItemDTO;
import com.hexbee.usermanagement.entity.InvoiceItemEntity;

@Service
public interface InvoiceItemService {

    InvoiceItemEntity createInvoiceItem(InvoiceItemDTO invoiceItemDTO);
    InvoiceItemEntity updateInvoiceItem(Integer id, InvoiceItemDTO invoiceItemDTO);
    InvoiceItemEntity getInvoiceItemById(Integer id);
    void deleteInvoiceItem(Integer id);
	List<InvoiceItemEntity> getAllInvoiceItems();
	


}
