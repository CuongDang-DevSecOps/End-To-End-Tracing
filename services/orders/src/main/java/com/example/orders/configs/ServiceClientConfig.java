package com.example.orders.configs;

import com.example.orders.clients.InventoryServiceClient;
import com.example.orders.clients.NotificationServiceClient;
import com.example.orders.clients.PaymentServiceClient;
import com.example.orders.clients.ShipmentServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ServiceClientConfig {

    @Bean
    public InventoryServiceClient inventoryServiceClient() {

        var webClient = WebClient.builder()
                .baseUrl("http://localhost:8011/")
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(InventoryServiceClient.class);
    }

    @Bean
    public PaymentServiceClient paymentServiceClient() {

        var webClient = WebClient.builder()
                .baseUrl("http://localhost:8012/")
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(PaymentServiceClient.class);
    }

    @Bean
    public ShipmentServiceClient shipmentServiceClient() {

        var webClient = WebClient.builder()
                .baseUrl("http://localhost:8013/")
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(ShipmentServiceClient.class);
    }

    @Bean
    public NotificationServiceClient notificationServiceClient() {

        var webClient = WebClient.builder()
                .baseUrl("http://localhost:8014/")
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(NotificationServiceClient.class);
    }
}
