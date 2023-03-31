package com.example.orders.handlers;

import com.example.orders.facades.ReceiptFacade;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record ReceiptHandler(ReceiptFacade receiptFacade) {

    public Mono<ServerResponse> retrieveReceipt(ServerRequest serverRequest) {
        return this.receiptFacade.retrieveReceipt(serverRequest.pathVariable("orderId"))
                .flatMap(receiptResponse -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(receiptResponse)));
    }
}
