
package com.hexbee.usermanagement.exceptionHandler;

import java.util.Date;


public class ErrorMessage {

	private int statusCode;

	private Date timestamp;
	private String message;
	private String description;

	public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
		super();
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}



	public ErrorMessage(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}