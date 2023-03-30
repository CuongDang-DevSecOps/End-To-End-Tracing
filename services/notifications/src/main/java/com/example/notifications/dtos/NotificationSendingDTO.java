package com.example.notifications.dtos;

import com.example.notifications.enums.NotificationSendingStatus;
import com.example.notifications.enums.NotificationSendingType;

public record NotificationSendingDTO(String notifyId, NotificationSendingStatus status, NotificationSendingType type) {
}
