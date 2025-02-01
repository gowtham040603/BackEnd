package com.hexbee.usermanagement.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

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



	

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", pricePerUnit=" + pricePerUnit + ", unit=" + unit
				+ ", cgst=" + cgst + ", sgst=" + sgst + ", hsnsac=" + hsnsac + ", stock=" + stock + ", isActive="
				+ isActive + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
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





	public ProductEntity(Integer id, String name, Double pricePerUnit, String unit, Double cgst, Double sgst,
			Integer hsnsac, Integer stock, Boolean isActive, UserEntity createdBy, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.pricePerUnit = pricePerUnit;
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


	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
