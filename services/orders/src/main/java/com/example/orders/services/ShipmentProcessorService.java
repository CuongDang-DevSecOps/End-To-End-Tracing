package com.example.orders.services;

import com.example.orders.dtos.SSShippingDetailsDTO;
import com.example.orders.dtos.SSShippingRequestDTO;
import com.example.orders.dtos.SSShippingResultResponseDTO;
import reactor.core.publisher.Mono;

public interface ShipmentProcessorService {

    Mono<SSShippingResultResponseDTO> ship(SSShippingRequestDTO requestDTO);

    Mono<SSShippingDetailsDTO> retrieveDetails(String orderId);
}
