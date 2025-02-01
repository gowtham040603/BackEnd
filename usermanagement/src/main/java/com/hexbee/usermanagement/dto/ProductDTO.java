package com.hexbee.usermanagement.dto;



public class ProductDTO {
    private String name;
    private Double pricePerUnit;
    private String unit;
    private Double cgst;
    private Double sgst;
    private Integer hsnsac;
    private Integer stock;
    private Integer createdBy;
    private Boolean isActive;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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



	public Integer getHsnsac() {
		return hsnsac;
	}



	public void setHsnsac(Integer hsnsac) {
		this.hsnsac = hsnsac;
	}



	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
	}



	public Integer getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String name, Double pricePerUnit, String unit, Double cgst, Double sgst, Integer hsnsac,
			Integer stock, Integer createdBy, Boolean isActive) {
		super();
		this.name = name;
		this.pricePerUnit = pricePerUnit;
		this.unit = unit;
		this.cgst = cgst;
		this.sgst = sgst;
		this.hsnsac = hsnsac;
		this.stock = stock;
		this.createdBy = createdBy;
		this.isActive = isActive;
	}



	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", pricePerUnit=" + pricePerUnit + ", unit=" + unit + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", hsnsac=" + hsnsac + ", stock=" + stock + ", createdBy=" + createdBy
				+ ", isActive=" + isActive + "]";
	}




	

	
	
	
}
