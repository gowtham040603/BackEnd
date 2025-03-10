package com.hexbee.usermanagement.dto;



public class SlabDTO {
    
    private Long id;
    private double fromAmount;
    private double toAmount;
    private double amount;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(double fromAmount) {
		this.fromAmount = fromAmount;
	}
	public double getToAmount() {
		return toAmount;
	}
	public void setToAmount(double toAmount) {
		this.toAmount = toAmount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public SlabDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SlabDTO(Long id, double fromAmount, double toAmount, double amount) {
		super();
		this.id = id;
		this.fromAmount = fromAmount;
		this.toAmount = toAmount;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "SlabDTO [id=" + id + ", fromAmount=" + fromAmount + ", toAmount=" + toAmount + ", amount=" + amount
				+ "]";
	}

      

}
