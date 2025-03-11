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
@Table(name = "vendor")
public class VendorEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    
	    @NotBlank(message = "name is mandatory")
	    @Column(nullable = false)
	    private String vendorName;

	    @NotBlank(message = "code is mandatory")
	    @Column(name="vendorCode",unique = true, nullable = false)
	    private String vendorCode;

	    @NotBlank(message = "gstNumber is mandatory")
	    @Column(name="gst_Number",unique = true, nullable = false)
	    private String gstNumber;

	    @NotBlank(message = "contactPerson is mandatory")
	    @Column(name="contact_person")
	    private String contactPerson;
	    
	    @NotBlank(message = "phoneNumber is mandatory")
	    @Column(name="phone_number")
	    private String phoneNumber;
	    
	    @NotBlank(message = "address is mandatory")
		@Column(name="address",nullable = false)
	    private String address;
	    
	    @Email
	    @NotBlank(message = "EmailId is mandatory")
	    @Column(unique = true, nullable = false)
	    private String email;    

	
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

		public String getVendorName() {
			return vendorName;
		}

		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}

		public String getVendorCode() {
			return vendorCode;
		}

		public void setVendorCode(String vendorCode) {
			this.vendorCode = vendorCode;
		}

		public String getGstNumber() {
			return gstNumber;
		}

		public void setGstNumber(String gstNumber) {
			this.gstNumber = gstNumber;
		}

		public String getContactPerson() {
			return contactPerson;
		}

		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
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

		public VendorEntity(Long id, @NotBlank(message = "name is mandatory") String vendorName,
				@NotBlank(message = "code is mandatory") String vendorCode,
				@NotBlank(message = "gstNumber is mandatory") String gstNumber,
				@NotBlank(message = "contactPerson is mandatory") String contactPerson,
				@NotBlank(message = "phoneNumber is mandatory") String phoneNumber,
				@NotBlank(message = "address is mandatory") String address,
				@Email @NotBlank(message = "EmailId is mandatory") String email, LocalDateTime createdAt,
				LocalDateTime updatedAt) {
			super();
			this.id = id;
			this.vendorName = vendorName;
			this.vendorCode = vendorCode;
			this.gstNumber = gstNumber;
			this.contactPerson = contactPerson;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.email = email;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}

		@Override
		public String toString() {
			return "VendorEntity [id=" + id + ", vendorName=" + vendorName + ", vendorCode=" + vendorCode
					+ ", gstNumber=" + gstNumber + ", contactPerson=" + contactPerson + ", phoneNumber=" + phoneNumber
					+ ", address=" + address + ", email=" + email + ", createdAt=" + createdAt + ", updatedAt="
					+ updatedAt + "]";
		}

		public VendorEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		
	    
}
