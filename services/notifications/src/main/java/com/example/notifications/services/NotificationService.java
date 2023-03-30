package com.example.notifications.services;

import com.example.notifications.dtos.NotificationSendingDTO;
import com.example.notifications.dtos.NotificationSendingRequestDTO;
import reactor.core.publisher.Mono;

public interface NotificationService {

    Mono<NotificationSendingDTO> proceedNotification(NotificationSendingRequestDTO requestDTO);
}
