package com.example.orders.configs;

import com.example.orders.handlers.OrderHandler;
import com.example.orders.handlers.ReceiptHandler;
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
    public RouterFunction<ServerResponse> orderRoutes(final OrderHandler orderHandler) {
        return route()
                .POST("/api/v1/place-orders", RequestPredicates.contentType(MediaType.APPLICATION_JSON), orderHandler::placeOrder)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> receiptRoutes(final ReceiptHandler receiptHandler) {
        return route()
                .GET("/api/v1/receipts/{orderId}", receiptHandler::retrieveReceipt)
                .build();
    }
}
