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
@Table(name="user")
public class UserEntity {

	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer  id;
	 
	 @Column(name="username",nullable = false, length = 50)
	 private String username;

	 @Column(name="password",nullable = false)
	 private String password;
	 
	 @Email
	 @NotBlank(message = "Email is mandatory")
	 @Column(unique = true, nullable = false)
	 private String email;
	 
	 @Column(name="phone")
	 private String phone;
	 
	 @Column(name="shopname")
	 private String shopname;
	 
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
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



	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", shopname=" + shopname + ", address=" + address + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Integer id, String username, String password,
			@Email @NotBlank(message = "Email is mandatory") String email, String phone, String shopname,
			String address, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.shopname = shopname;
		this.address = address;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	
}
