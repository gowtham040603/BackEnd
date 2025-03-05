package com.hexbee.usermanagement.service;

import com.hexbee.usermanagement.dto.NotificationRequest;

public interface NotificationService {

	void sendNotification(NotificationRequest request);

	

}
