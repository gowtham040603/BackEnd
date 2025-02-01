package com.hexbee.usermanagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.Repository.InvoiceItemRepository;
import com.hexbee.usermanagement.Repository.InvoiceRepository;
import com.hexbee.usermanagement.Repository.ProductRepository;
import com.hexbee.usermanagement.dto.InvoiceItemDTO;
import com.hexbee.usermanagement.entity.InvoiceEntity;
import com.hexbee.usermanagement.entity.InvoiceItemEntity;
import com.hexbee.usermanagement.entity.ProductEntity;
import com.hexbee.usermanagement.service.InvoiceItemService;

@Service
public class InvoiceItemServiceImpl  implements InvoiceItemService{

	   @Autowired
	    private InvoiceItemRepository invoiceItemRepository;

	   @Autowired
	    private InvoiceRepository invoiceRepository;

	   @Autowired
	    private ProductRepository productRepository;
	

	    @Override
	    public InvoiceItemEntity createInvoiceItem(InvoiceItemDTO invoiceItemDTO) {
	    	if (invoiceItemDTO.getInvoiceId() == null || invoiceItemDTO.getProductId() == null) {
	            throw new IllegalArgumentException("Invoice ID and Product ID must not be null");
	        }

	        InvoiceEntity invoice = invoiceRepository.findById(invoiceItemDTO.getInvoiceId())
	                .orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + invoiceItemDTO.getInvoiceId()));

	        ProductEntity product = productRepository.findById(invoiceItemDTO.getProductId())
	                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + invoiceItemDTO.getProductId()));

	        InvoiceItemEntity item = new InvoiceItemEntity();
	        item.setInvoice(invoice);
	        item.setProduct(product);
	        item.setQuantity(invoiceItemDTO.getQuantity());
	        item.setDiscount(invoiceItemDTO.getDiscount());
	        item.setCgst(invoiceItemDTO.getCgst());
	        item.setSgst(invoiceItemDTO.getSgst());
	        item.setSgstAmount(invoiceItemDTO.getSgstAmount());
	        item.setCgstAmount(invoiceItemDTO.getCgstAmount());
	        item.setTotalPrice(invoiceItemDTO.getTotalPrice());
	        item.setIsActive(invoiceItemDTO.getIsActive());
	    
	        return invoiceItemRepository.save(item);
	    }

	    @Override
	    public InvoiceItemEntity updateInvoiceItem(Integer id, InvoiceItemDTO invoiceItemDTO) {
	        InvoiceItemEntity entity = invoiceItemRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Invoice Item not found with ID: " + id));

	        entity.setQuantity(invoiceItemDTO.getQuantity());
	        entity.setDiscount(invoiceItemDTO.getDiscount());
	        entity.setCgst(invoiceItemDTO.getCgst());
	        entity.setSgst(invoiceItemDTO.getSgst());
	        entity.setSgstAmount(invoiceItemDTO.getSgstAmount());
	        entity.setCgstAmount(invoiceItemDTO.getCgstAmount());
	        entity.setTotalPrice(invoiceItemDTO.getTotalPrice());
	        entity.setIsActive(invoiceItemDTO.getIsActive());
	        
	        return invoiceItemRepository.save(entity);
	    }

	    @Override
	    public InvoiceItemEntity getInvoiceItemById(Integer id) {
	        InvoiceItemEntity entity = invoiceItemRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Invoice Item not found with ID: " + id));
	        return entity;
	    }

	    @Override
	    public List<InvoiceItemEntity> getAllInvoiceItems() {
	        return invoiceItemRepository.findAll();
	    }

	    @Override
	    public void deleteInvoiceItem(Integer id) {
	        invoiceItemRepository.deleteById(id);
	    }
}
