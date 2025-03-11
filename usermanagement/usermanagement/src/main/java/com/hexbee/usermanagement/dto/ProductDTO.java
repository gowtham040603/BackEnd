package com.hexbee.usermanagement.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductDTO {
	
    private String name;
    private Double pricePerUnit;
    private String unit;
    private Double cgst;
    private Double sgst;
    private Integer hsnsac;
    private String barcode;
    private String category;
    private String tax;
    private Double sellingPrice;
    private Double discount;
    private Double purchasePrice;
    private Boolean isSpWithTax;
    private Boolean isPpWithTax;
    private Integer minStockAlert;
    private String unitMeasurement;
    private Integer batchNumber;
;
    private String imageUrl;
    private Integer stock;
    private Integer createdBy;
    private Boolean isActive;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate  date;

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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Boolean getIsSpWithTax() {
		return isSpWithTax;
	}

	public void setIsSpWithTax(Boolean isSpWithTax) {
		this.isSpWithTax = isSpWithTax;
	}

	public Boolean getIsPpWithTax() {
		return isPpWithTax;
	}

	public void setIsPpWithTax(Boolean isPpWithTax) {
		this.isPpWithTax = isPpWithTax;
	}

	public Integer getMinStockAlert() {
		return minStockAlert;
	}

	public void setMinStockAlert(Integer minStockAlert) {
		this.minStockAlert = minStockAlert;
	}

	public String getUnitMeasurement() {
		return unitMeasurement;
	}

	public void setUnitMeasurement(String unitMeasurement) {
		this.unitMeasurement = unitMeasurement;
	}

	public Integer getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(Integer batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", pricePerUnit=" + pricePerUnit + ", unit=" + unit + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", hsnsac=" + hsnsac + ", barcode=" + barcode + ", category=" + category + ", tax="
				+ tax + ", sellingPrice=" + sellingPrice + ", discount=" + discount + ", purchasePrice=" + purchasePrice
				+ ", isSpWithTax=" + isSpWithTax + ", isPpWithTax=" + isPpWithTax + ", minStockAlert=" + minStockAlert
				+ ", unitMeasurement=" + unitMeasurement + ", batchNumber=" + batchNumber + ", imageUrl=" + imageUrl
				+ ", stock=" + stock + ", createdBy=" + createdBy + ", isActive=" + isActive + ", date=" + date + "]";
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String name, Double pricePerUnit, String unit, Double cgst, Double sgst, Integer hsnsac,
			String barcode, String category, String tax, Double sellingPrice, Double discount, Double purchasePrice,
			Boolean isSpWithTax, Boolean isPpWithTax, Integer minStockAlert, String unitMeasurement,
			Integer batchNumber, String imageUrl, Integer stock, Integer createdBy, Boolean isActive, LocalDate date) {
		super();
		this.name = name;
		this.pricePerUnit = pricePerUnit;
		this.unit = unit;
		this.cgst = cgst;
		this.sgst = sgst;
		this.hsnsac = hsnsac;
		this.barcode = barcode;
		this.category = category;
		this.tax = tax;
		this.sellingPrice = sellingPrice;
		this.discount = discount;
		this.purchasePrice = purchasePrice;
		this.isSpWithTax = isSpWithTax;
		this.isPpWithTax = isPpWithTax;
		this.minStockAlert = minStockAlert;
		this.unitMeasurement = unitMeasurement;
		this.batchNumber = batchNumber;
		this.imageUrl = imageUrl;
		this.stock = stock;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.date = date;
	}

	
	
	
}
