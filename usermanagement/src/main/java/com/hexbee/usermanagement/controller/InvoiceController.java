package com.hexbee.usermanagement.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexbee.usermanagement.dto.InvoiceDTO;
import com.hexbee.usermanagement.entity.InvoiceEntity;
import com.hexbee.usermanagement.service.InvoiceService;




@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

	    @Autowired
	    private InvoiceService invoiceService;

	    @PostMapping
	    public ResponseEntity<InvoiceEntity> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
	        InvoiceEntity createdInvoice = invoiceService.createInvoice(invoiceDTO);
	        return ResponseEntity.ok(createdInvoice);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<InvoiceEntity> updateInvoice(@PathVariable("id") Integer id, @RequestBody InvoiceDTO invoiceDTO) {
	        InvoiceEntity updatedInvoice = invoiceService.updateInvoice(id, invoiceDTO);
	        return ResponseEntity.ok(updatedInvoice);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") Integer id) {
	        invoiceService.deleteInvoice(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<InvoiceEntity> getInvoiceById(@PathVariable("id") Integer id) {
	        InvoiceEntity invoiceDTO = invoiceService.getInvoiceById(id);
	        return ResponseEntity.ok(invoiceDTO);
	    }

	    @GetMapping
	    public ResponseEntity<List<InvoiceEntity>> getAllInvoices() {
	        List<InvoiceEntity> invoices = invoiceService.getAllInvoices();
	        return ResponseEntity.ok(invoices);
	    }

	    
	    @GetMapping("/by-date-range")
	    public ResponseEntity<List<InvoiceEntity>> getInvoicesByDateRange(
	            @RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
	            @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate) {

	        List<InvoiceEntity> invoices = invoiceService.getInvoicesByDateRange(fromDate, toDate);
	        return ResponseEntity.ok(invoices);
	    }
	    
	    
	}


