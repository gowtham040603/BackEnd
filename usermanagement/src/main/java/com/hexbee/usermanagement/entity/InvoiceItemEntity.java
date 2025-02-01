package com.hexbee.usermanagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice_Item")
public class InvoiceItemEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	@Column(name = "quantity", nullable = false)
    private Double quantity;
	
	@Column(name = "discount",nullable = false)
    private Double discount;
	
	@Column(name = "cgst_per")
    private Double cgst;
	
    @Column(name = "sgst_per")
    private Double sgst;
    
    @Column(name = "sgst_amount")
    private Double sgstAmount;
    
    @Column(name = "cgst_amount")
    private Double cgstAmount;
	
	@Column(name = "total_price",nullable = false)
    private Double totalPrice;
	
    @Column(name = "active")
    private Boolean isActive = true;
    
    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private InvoiceEntity invoice;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getSgstAmount() {
		return sgstAmount;
	}

	public void setSgstAmount(Double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	public Double getCgstAmount() {
		return cgstAmount;
	}

	public void setCgstAmount(Double cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public InvoiceEntity getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



	public InvoiceItemEntity(Integer id, Double quantity, Double discount, Double cgst, Double sgst, Double sgstAmount,
			Double cgstAmount, Double totalPrice, Boolean isActive, InvoiceEntity invoice, ProductEntity product,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.discount = discount;
		this.cgst = cgst;
		this.sgst = sgst;
		this.sgstAmount = sgstAmount;
		this.cgstAmount = cgstAmount;
		this.totalPrice = totalPrice;
		this.isActive = isActive;
		this.invoice = invoice;
		this.product = product;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public InvoiceItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InvoiceItemEntity [id=" + id + ", quantity=" + quantity + ", discount=" + discount + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", sgstAmount=" + sgstAmount + ", cgstAmount=" + cgstAmount + ", totalPrice="
				+ totalPrice + ", isActive=" + isActive + ", invoice=" + invoice + ", product=" + product
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}


    
}
