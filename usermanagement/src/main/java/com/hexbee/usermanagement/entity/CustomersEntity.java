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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "customers")
public class CustomersEntity {

	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;

	 @Column(name="name",nullable = false, length = 50)
	 private String name;
	
	 @Email
	 @NotBlank(message = "Email is mandatory")
	 @Column(unique = true, nullable = false)
	 private String email;

	 @Column(name="phone")
	 private String phone;
	 
	 @Column(name="address")
	 private String address;

	 @Column(name = "active")
     private Boolean isActive = true;
	 
	 @CreationTimestamp
	 @Column(name = "created_at", nullable = false, updatable = false)
	 private LocalDateTime createdAt;

	 @UpdateTimestamp
	 @Column(name = "updated_at")
     private LocalDateTime updatedAt;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

	@Override
	public String toString() {
		return "CustomersEntity [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public CustomersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomersEntity(Integer id, String name, @Email @NotBlank(message = "Email is mandatory") String email,
			String phone, String address, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	 
}
