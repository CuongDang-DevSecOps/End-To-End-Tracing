package com.example.orders.services;

import com.example.orders.dtos.ISOrderingResultResponseDTO;
import reactor.core.publisher.Mono;

public interface OrderProcessorService {

    Mono<ISOrderingResultResponseDTO> order();
}
