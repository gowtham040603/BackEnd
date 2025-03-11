package com.hexbee.usermanagement.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class VendorDTO {
	
	private Long id;
	
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotBlank(message = "code is mandatory")
    private String code;
    
    @NotBlank(message = "GST Number is mandatory")
    private String gstNumber;
    
    @NotBlank(message = "Contact Person is mandatory")
    private String contactPerson;

    @NotBlank(message = "phoneNumber is mandatory") 
    private String phoneNumber;
    
    @Email
    @NotBlank(message = "EmailId is mandatory")
	@Column(unique = true)
    private String email;
    
    @NotBlank(message = "Address is mandatory")
    private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "VendorDTO [id=" + id + ", name=" + name + ", code=" + code + ", gstNumber=" + gstNumber
				+ ", contactPerson=" + contactPerson + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", address=" + address + "]";
	}

	public VendorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorDTO(Long id, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "code is mandatory") String code,
			@NotBlank(message = "GST Number is mandatory") String gstNumber,
			@NotBlank(message = "Contact Person is mandatory") String contactPerson,
			@NotBlank(message = "phoneNumber is mandatory") String phoneNumber,
			@NotBlank(message = "EmailId is mandatory") String email,
			@NotBlank(message = "Address is mandatory") String address) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.gstNumber = gstNumber;
		this.contactPerson = contactPerson;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}
    
    
    
    
}
