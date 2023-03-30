package com.example.orders.services.impl;

import com.example.orders.clients.NotificationServiceClient;
import com.example.orders.dtos.NSSendingRequestDTO;
import com.example.orders.dtos.NSSendingResultResponseDTO;
import com.example.orders.services.NotificationProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationProcessorServiceImpl implements NotificationProcessorService {

    private final NotificationServiceClient notificationServiceClient;

    @Override
    public Mono<NSSendingResultResponseDTO> notify(NSSendingRequestDTO requestDTO) {
        return notificationServiceClient.proceedNotification(requestDTO);
    }
}
