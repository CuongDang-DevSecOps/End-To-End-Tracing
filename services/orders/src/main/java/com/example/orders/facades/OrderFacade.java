package com.example.orders.facades;

import com.example.orders.dtos.PlaceOrderRequestDTO;
import com.example.orders.dtos.PlaceOrderResponseDTO;
import reactor.core.publisher.Mono;

public interface OrderFacade {

    Mono<PlaceOrderResponseDTO> placeOrder(PlaceOrderRequestDTO requestDTO);
}
