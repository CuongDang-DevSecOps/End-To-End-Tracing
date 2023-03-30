package com.example.payments.services;

import com.example.payments.dtos.PaymentChargingDTO;
import com.example.payments.dtos.PaymentChargingRequestDTO;
import reactor.core.publisher.Mono;

public interface PaymentService {

    Mono<PaymentChargingDTO> proceedPayment(PaymentChargingRequestDTO requestDTO);
}
