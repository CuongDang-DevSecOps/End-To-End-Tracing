package com.example.payments.services.impl;

import com.example.payments.dtos.PaymentChargingDTO;
import com.example.payments.dtos.PaymentChargingRequestDTO;
import com.example.payments.dtos.PaymentDetailsDTO;
import com.example.payments.enums.PaymentChargingStatus;
import com.example.payments.services.PaymentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Mono<PaymentChargingDTO> proceedPayment(PaymentChargingRequestDTO requestDTO) {
        // validate card
        // integrate payment gateway
        return Mono.just(new PaymentChargingDTO(UUID.randomUUID().toString(), PaymentChargingStatus.CHARGED));
    }

    @Override
    public Mono<PaymentDetailsDTO> retrievePaymentDetails(String orderId) {
        return Mono.just(new PaymentDetailsDTO(
                UUID.randomUUID().toString(), // dummy
                orderId,
                PaymentChargingStatus.CHARGED,
                ZonedDateTime.now().toOffsetDateTime().toString()));
    }
}
