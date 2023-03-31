package com.example.orders.clients;

import com.example.orders.dtos.PSChargingRequestDTO;
import com.example.orders.dtos.PSChargingResultResponseDTO;
import com.example.orders.dtos.PSPaymentDetailsDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@HttpExchange("/api/v1/payments")
public interface PaymentServiceClient {

    @PostExchange
    Mono<PSChargingResultResponseDTO> proceedPayment(@RequestBody PSChargingRequestDTO requestDTO);

    @GetExchange("{orderId}")
    Mono<PSPaymentDetailsDTO> retrievePaymentDetails(@PathVariable String orderId);
}
