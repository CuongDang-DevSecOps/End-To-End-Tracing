package com.example.orders.services;

import com.example.orders.dtos.ISOrderDetailsDTO;
import com.example.orders.dtos.ISOrderingResultResponseDTO;
import reactor.core.publisher.Mono;

public interface OrderProcessorService {

    Mono<ISOrderingResultResponseDTO> order();

    Mono<ISOrderDetailsDTO> retrieveDetails(String orderId);
}
