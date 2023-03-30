package com.example.orders.clients;

import com.example.orders.dtos.SSShippingRequestDTO;
import com.example.orders.dtos.SSShippingResultResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@HttpExchange("/api/v1/shipments")
public interface ShipmentServiceClient {

    @PostExchange
    Mono<SSShippingResultResponseDTO> proceedShipment(@RequestBody SSShippingRequestDTO requestDTO);
}
