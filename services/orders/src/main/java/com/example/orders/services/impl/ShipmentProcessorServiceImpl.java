package com.example.orders.services.impl;

import com.example.orders.clients.ShipmentServiceClient;
import com.example.orders.dtos.SSShippingRequestDTO;
import com.example.orders.dtos.SSShippingResultResponseDTO;
import com.example.orders.services.ShipmentProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ShipmentProcessorServiceImpl implements ShipmentProcessorService {

    private final ShipmentServiceClient shipmentServiceClient;

    @Override
    public Mono<SSShippingResultResponseDTO> ship(SSShippingRequestDTO requestDTO) {
        return shipmentServiceClient.proceedShipment(requestDTO);
    }
}
