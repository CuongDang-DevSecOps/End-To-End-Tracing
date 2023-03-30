package com.example.shipments.services;

import com.example.shipments.dtos.ShippingDTO;
import com.example.shipments.dtos.ShippingRequestDTO;
import reactor.core.publisher.Mono;

public interface ShipmentService {

    Mono<ShippingDTO> proceedShipment(ShippingRequestDTO requestDTO);
}
