package com.example.orders.facades.impl;

import com.example.orders.dtos.ReceiptResponseDTO;
import com.example.orders.facades.ReceiptFacade;
import com.example.orders.mappers.OrderMapper;
import com.example.orders.services.OrderProcessorService;
import com.example.orders.services.PaymentProcessorService;
import com.example.orders.services.ShipmentProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReceiptFacadeImpl implements ReceiptFacade {

    private final OrderProcessorService orderProcessorService;
    private final PaymentProcessorService paymentProcessorService;
    private final ShipmentProcessorService shipmentProcessorService;
    private final OrderMapper orderMapper;

    @Override
    public Mono<ReceiptResponseDTO> retrieveReceipt(String orderId) {

        // 1. retrieve order details
        // 2. retrieve payment details
        // 3. retrieve shipment details
        // 4. merge data
        return Mono.zip(
                        orderProcessorService.retrieveDetails(orderId),
                        paymentProcessorService.retrieveDetails(orderId),
                        shipmentProcessorService.retrieveDetails(orderId))
                .map(objects -> orderMapper.toReceiptResponse(objects.getT1(), objects.getT2(), objects.getT3()));
    }
}
