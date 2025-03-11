package com.hexbee.usermanagement.dto;

import jakarta.persistence.Column;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserSaveDTO {

		@NotBlank(message = "userName is mandatory")
		private String username;
		
		@NotBlank(message = "New password is mandatory")
		@Size(min = 8, max = 20)
	    private String password;
	    
	    @Email
		@NotBlank(message = "Email is mandatory")
		@Column(unique = true)
	    private String email;
	    
	    @NotBlank(message = "phone number is mandatory")
	    private String phone;
	    
	    @NotBlank(message = "gstNumber is mandatory")
		private String gstNumber;
	    
	    @NotBlank(message = "signature is mandatory")
		private String signature;
	    
	    @NotBlank(message = "shopname is mandatory")
		private String shopname;
		
	    @NotBlank(message = "address is mandatory")
		private String address;
		
		private Boolean isActive;

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

		public String getGstNumber() {
			return gstNumber;
		}

		public void setGstNumber(String gstNumber) {
			this.gstNumber = gstNumber;
		}

		public String getSignature() {
			return signature;
		}

		public void setSignature(String signature) {
			this.signature = signature;
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
			return "UserSaveDTO [username=" + username + ", password=" + password + ", email=" + email + ", phone="
					+ phone + ", gstNumber=" + gstNumber + ", signature=" + signature + ", shopname=" + shopname
					+ ", address=" + address + ", isActive=" + isActive + "]";
		}

		public UserSaveDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserSaveDTO(@NotBlank(message = "userName is mandatory") String username,
				@NotBlank(message = "New password is mandatory") @Size(min = 8, max = 20) String password,
				@Email @NotBlank(message = "Email is mandatory") String email,
				@NotBlank(message = "phone number is mandatory") String phone,
				@NotBlank(message = "gstNumber is mandatory") String gstNumber,
				@NotBlank(message = "signature is mandatory") String signature,
				@NotBlank(message = "shopname is mandatory") String shopname,
				@NotBlank(message = "address is mandatory") String address, Boolean isActive) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.phone = phone;
			this.gstNumber = gstNumber;
			this.signature = signature;
			this.shopname = shopname;
			this.address = address;
			this.isActive = isActive;
		}
		

		
	}



