package com.hexbee.usermanagement.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CustomersDTO {

	@NotBlank(message = "Name is mandatory")
	private String name;

	@Email
	@NotBlank(message = "Email is mandatory")
	@Column(unique = true)
    private String email;
	    
    @NotBlank(message = "phone is mandatory")
    private String phone;
  
    @NotBlank(message = "address is mandatory")
	private String address;
	
	private Boolean isActive;

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

	@Override
	public String toString() {
		return "CustomersDTO [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", isActive=" + isActive + "]";
	}

	public CustomersDTO(@NotBlank(message = "Name is mandatory") String name,
			@Email @NotBlank(message = "Email is mandatory") String email,
			@NotBlank(message = "phone is mandatory") String phone,
			@NotBlank(message = "address is mandatory") String address, Boolean isActive) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.isActive = isActive;
	}

	public CustomersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
