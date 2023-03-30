package com.example.orders.services.impl;

import com.example.orders.clients.PaymentServiceClient;
import com.example.orders.dtos.PSChargingRequestDTO;
import com.example.orders.dtos.PSChargingResultResponseDTO;
import com.example.orders.services.PaymentProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentProcessorServiceImpl implements PaymentProcessorService {

    private final PaymentServiceClient paymentServiceClient;

    @Override
    public Mono<PSChargingResultResponseDTO> pay(PSChargingRequestDTO requestDTO) {
        return paymentServiceClient.proceedPayment(requestDTO);
    }
}
