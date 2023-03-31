package com.example.shipments.services;

import com.example.shipments.dtos.ShippingDTO;
import com.example.shipments.dtos.ShippingRequestDTO;
import com.example.shipments.dtos.ShippingDetailsDTO;
import reactor.core.publisher.Mono;

public interface ShipmentService {

    Mono<ShippingDTO> proceedShipment(ShippingRequestDTO requestDTO);

    Mono<ShippingDetailsDTO> retrieveShipmentDetails(String orderId);
}
