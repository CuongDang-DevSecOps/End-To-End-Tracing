package com.example.orders.configs.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "inventory-service")
@Setter
@Getter
public class InventoryServiceProperties {

    private String baseUrl;
}
