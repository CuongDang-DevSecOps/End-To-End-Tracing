package com.example.orders.configs;

import com.example.orders.clients.InventoryServiceClient;
import com.example.orders.clients.NotificationServiceClient;
import com.example.orders.clients.PaymentServiceClient;
import com.example.orders.clients.ShipmentServiceClient;
import com.example.orders.configs.properties.InventoryServiceProperties;
import com.example.orders.configs.properties.NotificationServiceProperties;
import com.example.orders.configs.properties.PaymentServiceProperties;
import com.example.orders.configs.properties.ShipmentServiceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ServiceClientConfig {

    @Bean
    public InventoryServiceClient inventoryServiceClient(InventoryServiceProperties properties) {

        var webClient = WebClient.builder()
                .baseUrl(properties.getBaseUrl())
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(InventoryServiceClient.class);
    }

    @Bean
    public PaymentServiceClient paymentServiceClient(final PaymentServiceProperties properties) {

        var webClient = WebClient.builder()
                .baseUrl(properties.getBaseUrl())
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(PaymentServiceClient.class);
    }

    @Bean
    public ShipmentServiceClient shipmentServiceClient(final ShipmentServiceProperties properties) {

        var webClient = WebClient.builder()
                .baseUrl(properties.getBaseUrl())
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(ShipmentServiceClient.class);
    }

    @Bean
    public NotificationServiceClient notificationServiceClient(final NotificationServiceProperties properties) {

        var webClient = WebClient.builder()
                .baseUrl(properties.getBaseUrl())
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(NotificationServiceClient.class);
    }
}
