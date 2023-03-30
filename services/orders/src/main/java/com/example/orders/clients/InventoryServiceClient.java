package com.example.orders.clients;

import com.example.orders.dtos.ISOrderingResultResponseDTO;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@HttpExchange("/api/v1/inventories")
public interface InventoryServiceClient {

    @PostExchange
    Mono<ISOrderingResultResponseDTO> proceedOrder();
}
