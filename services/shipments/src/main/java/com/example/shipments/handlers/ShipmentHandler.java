package com.example.shipments.handlers;

import com.example.shipments.dtos.ShippingRequestDTO;
import com.example.shipments.services.ShipmentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record ShipmentHandler(ShipmentService shipmentService) {

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ShippingRequestDTO.class)
                .flatMap(this.shipmentService::proceedShipment)
                .flatMap(shippingDTO -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(shippingDTO)));
    }
}
