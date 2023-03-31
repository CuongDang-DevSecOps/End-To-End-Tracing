package com.example.orders.services.impl;

import com.example.orders.clients.InventoryServiceClient;
import com.example.orders.dtos.ISOrderDetailsDTO;
import com.example.orders.dtos.ISOrderingResultResponseDTO;
import com.example.orders.services.OrderProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderProcessorServiceImpl implements OrderProcessorService {

    private final InventoryServiceClient inventoryServiceClient;

    @Override
    public Mono<ISOrderingResultResponseDTO> order() {
        return inventoryServiceClient.proceedOrder();
    }

    @Override
    public Mono<ISOrderDetailsDTO> retrieveDetails(String orderId) {
        return inventoryServiceClient.retrieveOrderDetails(orderId);
    }
}
