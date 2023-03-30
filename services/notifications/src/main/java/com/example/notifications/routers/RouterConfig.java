package com.example.notifications.routers;

import com.example.notifications.handlers.NotificationHandler;
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
    public RouterFunction<ServerResponse> routes(NotificationHandler notificationHandler) {
        return route()
                .POST("/api/v1/notifications", RequestPredicates.contentType(MediaType.APPLICATION_JSON), notificationHandler::create)
                .build();
    }
}
