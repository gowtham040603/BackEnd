package com.hexbee.usermanagement.dto;

public class UserUpdateDTO {

		private String username;
	    private String password;
	    private String email;
	    private String phone;
		private String shopname;
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

		public UserUpdateDTO(Integer id, String username, String password, String email, String phone, String shopname,
				String address, Boolean isActive) {
			super();
			
			this.username = username;
			this.password = password;
			this.email = email;
			this.phone = phone;
			this.shopname = shopname;
			this.address = address;
			this.isActive = isActive;
		}

		
		@Override
		public String toString() {
			return "UserUpdateDTO [username=" + username + ", password=" + password + ", email=" + email + ", phone="
					+ phone + ", shopname=" + shopname + ", address=" + address + ", isActive=" + isActive + "]";
		}
		public UserUpdateDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
	}


