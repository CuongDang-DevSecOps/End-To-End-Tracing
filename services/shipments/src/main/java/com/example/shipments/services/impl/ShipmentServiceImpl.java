package com.example.shipments.services.impl;

import com.example.shipments.dtos.ShippingDTO;
import com.example.shipments.dtos.ShippingRequestDTO;
import com.example.shipments.enums.ShippingStatus;
import com.example.shipments.services.ShipmentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Override
    public Mono<ShippingDTO> proceedShipment(ShippingRequestDTO requestDTO) {
        return Mono.just(new ShippingDTO(UUID.randomUUID().toString(), ShippingStatus.SENT));
    }
}
