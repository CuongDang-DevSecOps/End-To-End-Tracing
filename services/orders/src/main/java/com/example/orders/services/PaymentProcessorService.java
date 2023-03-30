package com.example.orders.services;

import com.example.orders.dtos.PSChargingRequestDTO;
import com.example.orders.dtos.PSChargingResultResponseDTO;
import reactor.core.publisher.Mono;

public interface PaymentProcessorService {

    Mono<PSChargingResultResponseDTO> pay(PSChargingRequestDTO requestDTO);
}
