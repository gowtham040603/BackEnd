package com.hexbee.usermanagement.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "slab")
public class SlabEntity {
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "FromAmount")
	 private double fromAmount ;
     
	 @Column(name = "ToAmount")
	 private double toAmount ;
	 
	 @Column(name = "Amount")
	 private double amount ;
	 
     @CreationTimestamp
	 @Column(name = "created_at", nullable = false, updatable = false)
	 private LocalDateTime createdAt;

	 @UpdateTimestamp
	 @Column(name = "updated_at")
     private LocalDateTime updatedAt;

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

	public SlabEntity(Long id, double fromAmount, double toAmount, double amount, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.fromAmount = fromAmount;
		this.toAmount = toAmount;
		this.amount = amount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public SlabEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SlabEntity [id=" + id + ", fromAmount=" + fromAmount + ", toAmount=" + toAmount + ", amount=" + amount
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	 
	 
	 


}
