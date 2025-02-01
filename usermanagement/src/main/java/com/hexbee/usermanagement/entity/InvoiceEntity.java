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
@Table(name = "invoice")
public class InvoiceEntity {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer id;

	  @Column(name = "invoice_number", nullable = false, unique = true)
	  private String invoiceNumber;
	  
	  @Column(name = "total_amount", nullable = false)
	  private Double totalAmount;
	  
	  @Column(name = "gst_amount")
	  private Double gstAmount;
	  
	  @Column(name = "final_amount")
	  private Double finalAmount;
	  
	  @Column(name = "paid_amount")
	  private Double paidAmount;
	  
	  @Column(name = "balance_amount")
	  private Double balanceAmount;
	  
	  @Column(name = "discount",nullable = false)
      private Double discount;
	  
	  @Column(name = "active")
	  private Boolean isActive = true;
	  
	  @ManyToOne
	  @JoinColumn(name = "created_by")
	  private UserEntity createdBy;
	  
	  @ManyToOne
	  @JoinColumn(name = "customer_id")
	  private  CustomersEntity  customerId;

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

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(Double gstAmount) {
		this.gstAmount = gstAmount;
	}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}

	public CustomersEntity getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomersEntity customerId) {
		this.customerId = customerId;
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

	public InvoiceEntity(Integer id, String invoiceNumber, Double totalAmount, Double gstAmount, Double finalAmount,
			Double paidAmount, Double balanceAmount, Double discount, Boolean isActive, UserEntity createdBy,
			CustomersEntity customerId, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.totalAmount = totalAmount;
		this.gstAmount = gstAmount;
		this.finalAmount = finalAmount;
		this.paidAmount = paidAmount;
		this.balanceAmount = balanceAmount;
		this.discount = discount;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.customerId = customerId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "InvoiceEntity [id=" + id + ", invoiceNumber=" + invoiceNumber + ", totalAmount=" + totalAmount
				+ ", gstAmount=" + gstAmount + ", finalAmount=" + finalAmount + ", paidAmount=" + paidAmount
				+ ", balanceAmount=" + balanceAmount + ", discount=" + discount + ", isActive=" + isActive
				+ ", createdBy=" + createdBy + ", customerId=" + customerId + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	public InvoiceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	  
	  
}
