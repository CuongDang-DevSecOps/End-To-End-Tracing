package com.example.orders.services;

import com.example.orders.dtos.PSChargingRequestDTO;
import com.example.orders.dtos.PSChargingResultResponseDTO;
import com.example.orders.dtos.PSPaymentDetailsDTO;
import reactor.core.publisher.Mono;

public interface PaymentProcessorService {

    Mono<PSChargingResultResponseDTO> pay(PSChargingRequestDTO requestDTO);

    Mono<PSPaymentDetailsDTO> retrieveDetails(String orderId);
}
