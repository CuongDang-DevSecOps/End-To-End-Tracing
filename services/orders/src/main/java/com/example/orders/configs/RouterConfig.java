package com.example.orders.configs;

import com.example.orders.handlers.OrderHandler;
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
    public RouterFunction<ServerResponse> routes(OrderHandler orderHandler) {
        return route()
                .POST("/api/v1/place-orders", RequestPredicates.contentType(MediaType.APPLICATION_JSON), orderHandler::placeOrder)
                .build();
    }
}
