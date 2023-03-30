package com.example.notifications.services.impl;

import com.example.notifications.dtos.NotificationSendingDTO;
import com.example.notifications.dtos.NotificationSendingRequestDTO;
import com.example.notifications.services.NotificationService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.example.notifications.enums.NotificationSendingStatus.SENT;
import static com.example.notifications.enums.NotificationSendingType.EMAIL;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public Mono<NotificationSendingDTO> proceedNotification(NotificationSendingRequestDTO requestDTO) {
        return Mono.just(new NotificationSendingDTO(UUID.randomUUID().toString(), SENT, EMAIL));
    }
}
