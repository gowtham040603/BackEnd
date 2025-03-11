package com.hexbee.usermanagement.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    @Column(name = "barcode")
    private String barcode;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "tax")
    private String tax;
    
    @Column(name = "selling_price")
    private Double sellingPrice;
    
    @Column(name = "discount")
    private Double discount;
    
    @Column(name = "purchase_price")
    private Double purchasePrice;
    
    @Column(name = "is_sp_with_tax")
    private Boolean isSpWithTax ;
    
    @Column(name = "is_pp_with_tax")
    private Boolean isPpWithTax;
    
    @Column(name = "min_stock_alert")
    private Integer minStockAlert;
    
    @Column(name = "unit_measurement")
    private String unitMeasurement;
    
    @Column(name = "batch_number")
    private Integer batchNumber;
    
    @Column(name = "date", nullable = false)
    private LocalDate date;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "unit")
    private String unit;

    @Column(name = "cgst")
    private Double cgst;
    
    @Column(name = "sgst")
    private Double sgst;
    
    @Column(name = "hsn_sac")
    private Integer hsnsac;
    
    @Column(name = "stock")
    private Integer stock;

	@Column(name = "active")
    private Boolean isActive = true;
	
    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = LocalDate.now();
        }
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

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
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

	public LocalDate  getDate() {
		return date;
	}

	public void setDate(LocalDate  date) {
		this.date = date;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", pricePerUnit=" + pricePerUnit + ", barcode=" + barcode
				+ ", category=" + category + ", tax=" + tax + ", sellingPrice=" + sellingPrice + ", discount="
				+ discount + ", purchasePrice=" + purchasePrice + ", isSpWithTax=" + isSpWithTax + ", isPpWithTax="
				+ isPpWithTax + ", minStockAlert=" + minStockAlert + ", unitMeasurement=" + unitMeasurement
				+ ", batchNumber=" + batchNumber + ", date=" + date + ", imageUrl=" + imageUrl + ", unit=" + unit
				+ ", cgst=" + cgst + ", sgst=" + sgst + ", hsnsac=" + hsnsac + ", stock=" + stock + ", isActive="
				+ isActive + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public ProductEntity(Integer id, String name, Double pricePerUnit, String barcode, String category, String tax,
			Double sellingPrice, Double discount, Double purchasePrice, Boolean isSpWithTax, Boolean isPpWithTax,
			Integer minStockAlert, String unitMeasurement, Integer batchNumber, LocalDate  date, String imageUrl,
			String unit, Double cgst, Double sgst, Integer hsnsac, Integer stock, Boolean isActive,
			UserEntity createdBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.pricePerUnit = pricePerUnit;
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
		this.date = date;
		this.imageUrl = imageUrl;
		this.unit = unit;
		this.cgst = cgst;
		this.sgst = sgst;
		this.hsnsac = hsnsac;
		this.stock = stock;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	


}
