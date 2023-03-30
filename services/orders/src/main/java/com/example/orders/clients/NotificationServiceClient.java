package com.example.orders.clients;

import com.example.orders.dtos.NSSendingRequestDTO;
import com.example.orders.dtos.NSSendingResultResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@HttpExchange("/api/v1/notifications")
public interface NotificationServiceClient {

    @PostExchange
    Mono<NSSendingResultResponseDTO> proceedNotification(@RequestBody NSSendingRequestDTO requestDTO);
}
