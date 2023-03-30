package com.example.shipments.routers;

import com.example.shipments.handlers.ShipmentHandler;
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
    public RouterFunction<ServerResponse> routes(ShipmentHandler shipmentHandler) {
        return route()
                .POST("/api/v1/shipments", RequestPredicates.contentType(MediaType.APPLICATION_JSON), shipmentHandler::create)
                .build();
    }
}
