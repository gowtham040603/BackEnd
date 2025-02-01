package com.hexbee.usermanagement.dto;

public class InvoiceItemDTO {

	  private Integer invoiceId;
	  private Integer productId;
	  private Double quantity;
	  private Double discount;
	  private Double cgst;
	  private Double sgst;
	  private Double sgstAmount;
	  private Double cgstAmount;     
	  private Double totalPrice;
	  private Boolean isActive;
	  

	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "InvoiceItemDTO [invoiceId=" + invoiceId + ", productId=" + productId + ", quantity=" + quantity
				+ ", discount=" + discount + ", cgst=" + cgst + ", sgst=" + sgst + ", sgstAmount=" + sgstAmount
				+ ", cgstAmount=" + cgstAmount + ", totalPrice=" + totalPrice + ", isActive=" + isActive + "]";
	}
	
	public InvoiceItemDTO(Integer invoiceId, Integer productId, Double quantity, Double discount, Double cgst,
			Double sgst, Double sgstAmount, Double cgstAmount, Double totalPrice, Boolean isActive) {
		super();
		this.invoiceId = invoiceId;
		this.productId = productId;
		this.quantity = quantity;
		this.discount = discount;
		this.cgst = cgst;
		this.sgst = sgst;
		this.sgstAmount = sgstAmount;
		this.cgstAmount = cgstAmount;
		this.totalPrice = totalPrice;
		this.isActive = isActive;
	}
	public InvoiceItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
