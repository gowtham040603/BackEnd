package com.hexbee.usermanagement.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hexbee.usermanagement.entity.ProductEntity;

public class ProductResponseDTO {
	
    private Integer id;
    private String name;
    private double pricePerUnit;
    private String barcode;
    private String category;
    private String tax;
    private double sellingPrice;
    private double discount;
    private double purchasePrice;
    private boolean isSpWithTax;
    private boolean isPpWithTax;
    private int minStockAlert;
    private String subUnit;
    private Integer batchNumber;
    private String imageUrl;
    private String baseUnit;
    private Double cgst;
    private Double sgst;
    private long hsnsac;
    private int stock;
    private boolean isActive;
    private String stockStatus; // Computed property
    private Double unitCount;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate  date;

    public ProductResponseDTO(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.name = productEntity.getName();
        this.pricePerUnit = productEntity.getPricePerUnit();
        this.barcode = productEntity.getBarcode();
        this.category = productEntity.getCategory();
        this.tax = productEntity.getTax();
        this.sellingPrice = productEntity.getSellingPrice();
        this.discount = productEntity.getDiscount();
        this.purchasePrice = productEntity.getPurchasePrice();
        this.isSpWithTax = productEntity.getIsSpWithTax();
        this.isPpWithTax = productEntity.getIsPpWithTax();
        this.minStockAlert = productEntity.getMinStockAlert();
        this.subUnit = productEntity.getSubUnit();
        this.batchNumber = productEntity.getBatchNumber();
        this.imageUrl = productEntity.getImageUrl();
        this.baseUnit = productEntity.getBaseUnit();
        this.cgst = productEntity.getCgst();
        this.sgst = productEntity.getSgst();
        this.hsnsac = productEntity.getHsnsac();
        this.stock = productEntity.getStock();
        this.isActive = productEntity.getIsActive();
        this.stockStatus = getStockStatus(productEntity.getStock(), productEntity.getMinStockAlert());
        this.date = productEntity.getDate();
        this.unitCount = productEntity.getUnitCount();
    }
    
    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPricePerUnit() {
		return pricePerUnit;
	}



	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
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



	public double getSellingPrice() {
		return sellingPrice;
	}



	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}



	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public double getPurchasePrice() {
		return purchasePrice;
	}



	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}



	public boolean isSpWithTax() {
		return isSpWithTax;
	}



	public void setSpWithTax(boolean isSpWithTax) {
		this.isSpWithTax = isSpWithTax;
	}



	public boolean isPpWithTax() {
		return isPpWithTax;
	}



	public void setPpWithTax(boolean isPpWithTax) {
		this.isPpWithTax = isPpWithTax;
	}



	public int getMinStockAlert() {
		return minStockAlert;
	}



	public void setMinStockAlert(int minStockAlert) {
		this.minStockAlert = minStockAlert;
	}



	public String getSubUnit() {
		return subUnit;
	}



	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
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



	public String getBaseUnit() {
		return baseUnit;
	}



	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}
	
	public Double getUnitCount() {
		return unitCount;
	}

	public void setUnitCount(Double unitCount) {
		this.unitCount = unitCount;
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



	public long getHsnsac() {
		return hsnsac;
	}



	public void setHsnsac(long hsnsac) {
		this.hsnsac = hsnsac;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public String getStockStatus() {
		return stockStatus;
	}



	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}



	private String getStockStatus(int stock, int minStockAlert) {
        if (stock == 0) {
            return "OUT_OF_STOCK";
        } else if (stock < minStockAlert) {
            return "LOW_STOCK";
        } else {
            return "IN_STOCK";
        }
    }

    // Getters & Setters (or use Lombok @Getter @Setter)
}

