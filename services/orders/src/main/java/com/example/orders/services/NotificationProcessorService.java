package com.example.orders.services;

import com.example.orders.dtos.NSSendingRequestDTO;
import com.example.orders.dtos.NSSendingResultResponseDTO;
import reactor.core.publisher.Mono;

public interface NotificationProcessorService {

    Mono<NSSendingResultResponseDTO> notify(NSSendingRequestDTO requestDTO);
}
