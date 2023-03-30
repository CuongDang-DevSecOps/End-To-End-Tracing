package com.example.orders.handlers;

import com.example.orders.dtos.PlaceOrderRequestDTO;
import com.example.orders.facades.OrderFacade;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record OrderHandler(OrderFacade orderFacade) {

    public Mono<ServerResponse> placeOrder(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PlaceOrderRequestDTO.class)
                .flatMap(this.orderFacade::placeOrder)
                .flatMap(placeOrderResponse -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(placeOrderResponse)));
    }
}
