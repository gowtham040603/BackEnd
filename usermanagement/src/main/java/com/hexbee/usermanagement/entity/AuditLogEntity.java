package com.hexbee.usermanagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "audit_log")
public class AuditLogEntity {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;

	 @Column(name = "action", nullable = false)
	 private String action;
	 
	 @Column(name = "description")
     private String description;
	 
	 @Column(name = "timestamp", updatable = false, nullable = false)
     private LocalDateTime timestamp = LocalDateTime.now();
	 
	 @ManyToOne
	 @JoinColumn(name = "user_id", nullable = false)
     private UserEntity user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public AuditLogEntity(Integer id, String action, String description, LocalDateTime timestamp, UserEntity user) {
		super();
		this.id = id;
		this.action = action;
		this.description = description;
		this.timestamp = timestamp;
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuditLogEntity [id=" + id + ", action=" + action + ", description=" + description + ", timestamp="
				+ timestamp + ", user=" + user + "]";
	}

	public AuditLogEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


}
