package com.example.notifications.handlers;

import com.example.notifications.dtos.NotificationSendingRequestDTO;
import com.example.notifications.services.NotificationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record NotificationHandler(NotificationService notificationService) {

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(NotificationSendingRequestDTO.class)
                .flatMap(this.notificationService::proceedNotification)
                .flatMap(sendingDTO -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(sendingDTO)));
    }
}
