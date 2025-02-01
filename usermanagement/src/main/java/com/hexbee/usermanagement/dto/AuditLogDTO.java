package com.hexbee.usermanagement.dto;



public class AuditLogDTO {

    private Integer userId;
    private String action;
	private String description;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AuditLogDTO(Integer userId, String action, String description) {
		super();
		this.userId = userId;
		this.action = action;
		this.description = description;
	}
	@Override
	public String toString() {
		return "AuditLogDTO [userId=" + userId + ", action=" + action + ", description=" + description + "]";
	}
	public AuditLogDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

  
     
}
