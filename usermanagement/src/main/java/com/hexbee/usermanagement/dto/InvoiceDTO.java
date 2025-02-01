package com.hexbee.usermanagement.dto;

public class InvoiceDTO {
	
	  private String invoiceNumber;
	  private Integer customerId;
	  private Double totalAmount;
	  private Double gstAmount;
	  private Double finalAmount;
	  private Double paidAmount;
	  private Double balanceAmount;
	  private Double discount;
	  private Boolean isActive;
	  private Integer createdBy; 
	  
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerName(Integer customerId) {
		this.customerId = customerId;
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
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public InvoiceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public InvoiceDTO(String invoiceNumber, Integer customerId, Double totalAmount, Double gstAmount,
			Double finalAmount, Double paidAmount, Double balanceAmount, Double discount, Boolean isActive,
			Integer createdBy) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.customerId = customerId;
		this.totalAmount = totalAmount;
		this.gstAmount = gstAmount;
		this.finalAmount = finalAmount;
		this.paidAmount = paidAmount;
		this.balanceAmount = balanceAmount;
		this.discount = discount;
		this.isActive = isActive;
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		return "InvoiceDTO [invoiceNumber=" + invoiceNumber + ", customerId=" + customerId + ", totalAmount="
				+ totalAmount + ", gstAmount=" + gstAmount + ", finalAmount=" + finalAmount + ", paidAmount="
				+ paidAmount + ", balanceAmount=" + balanceAmount + ", discount=" + discount + ", isActive=" + isActive
				+ ", createdBy=" + createdBy + "]";
	}
	
}
