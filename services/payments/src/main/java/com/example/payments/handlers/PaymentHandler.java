package com.example.payments.handlers;

import com.example.payments.dtos.PaymentChargingRequestDTO;
import com.example.payments.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record PaymentHandler(PaymentService paymentService) {

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PaymentChargingRequestDTO.class)
                .flatMap(this.paymentService::proceedPayment)
                .flatMap(chargingDTO -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(chargingDTO)));
    }
}
