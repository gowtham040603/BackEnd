package com.hexbee.usermanagement.dto;

import java.util.Map;

import com.hexbee.usermanagement.notification.NotificationType;

public class NotificationRequest {
	
	    private NotificationType type;
	    private String recipient; // Email, phone number, or device token
	    private String displayName;
	    private String sender;
	    private String subject;
	    private String templateType;
	    private Map<String, Object> data;
	    
		public NotificationType getType() {
			return type;
		}
		public void setType(NotificationType type) {
			this.type = type;
		}
		public String getRecipient() {
			return recipient;
		}
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
		public String getDisplayName() {
			return displayName;
		}
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		public String getSender() {
			return sender;
		}
		public void setSender(String sender) {
			this.sender = sender;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getTemplateType() {
			return templateType;
		}
		public void setTemplateType(String templateType) {
			this.templateType = templateType;
		}
		public Map<String, Object> getData() {
			return data;
		}
		public void setData(Map<String, Object> data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "NotificationRequest [type=" + type + ", recipient=" + recipient + ", displayName=" + displayName
					+ ", sender=" + sender + ", subject=" + subject + ", templateType=" + templateType + ", data="
					+ data + "]";
		}
		public NotificationRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public NotificationRequest(NotificationType type, String recipient, String displayName, String sender,
				String subject, String templateType, Map<String, Object> data) {
			super();
			this.type = type;
			this.recipient = recipient;
			this.displayName = displayName;
			this.sender = sender;
			this.subject = subject;
			this.templateType = templateType;
			this.data = data;
		}
		

}
