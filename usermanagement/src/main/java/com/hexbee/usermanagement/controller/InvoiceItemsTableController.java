package com.hexbee.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexbee.usermanagement.dto.InvoiceItemDTO;
import com.hexbee.usermanagement.entity.InvoiceItemEntity;
import com.hexbee.usermanagement.service.InvoiceItemService;

@RestController
@RequestMapping("/api/invoiceItems")
public class InvoiceItemsTableController {

	 @Autowired
	 private InvoiceItemService invoiceItemService;
	 
	 @PostMapping
	    public ResponseEntity<InvoiceItemEntity> createInvoiceItem(@RequestBody InvoiceItemDTO invoiceItemDTO) {
		 InvoiceItemEntity createdItem = invoiceItemService.createInvoiceItem(invoiceItemDTO);
	        return ResponseEntity.ok(createdItem);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<InvoiceItemEntity> updateInvoiceItem(@PathVariable("id") Integer id, @RequestBody InvoiceItemDTO invoiceItemDTO) {
	    	InvoiceItemEntity updatedItem = invoiceItemService.updateInvoiceItem(id, invoiceItemDTO);
	        return ResponseEntity.ok(updatedItem);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<InvoiceItemEntity> getInvoiceItemById(@PathVariable("id") Integer id) {
	    	InvoiceItemEntity item = invoiceItemService.getInvoiceItemById(id);
	        return ResponseEntity.ok(item);
	    }

	    @GetMapping
	    public ResponseEntity<List<InvoiceItemEntity>> getAllInvoiceItems() {
	        List<InvoiceItemEntity> items = invoiceItemService.getAllInvoiceItems();
	        return ResponseEntity.ok(items);
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInvoiceItem(@PathVariable("id") Integer id) {
	        invoiceItemService.deleteInvoiceItem(id);
	        return ResponseEntity.noContent().build();
	    }
	}

