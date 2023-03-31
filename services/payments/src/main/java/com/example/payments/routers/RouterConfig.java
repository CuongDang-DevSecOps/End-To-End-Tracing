package com.example.payments.routers;

import com.example.payments.handlers.PaymentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(PaymentHandler paymentHandler) {
        return route()
                .POST("/api/v1/payments", RequestPredicates.contentType(MediaType.APPLICATION_JSON), paymentHandler::create)
                .GET("/api/v1/payments/{orderId}", paymentHandler::get)
                .build();
    }
}
