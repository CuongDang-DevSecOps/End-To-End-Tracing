package com.example.orders.facades.impl;

import com.example.orders.dtos.*;
import com.example.orders.facades.OrderFacade;
import com.example.orders.services.NotificationProcessorService;
import com.example.orders.services.OrderProcessorService;
import com.example.orders.services.PaymentProcessorService;
import com.example.orders.services.ShipmentProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OrderFacadeImpl implements OrderFacade {

    private final OrderProcessorService orderProcessorService;
    private final PaymentProcessorService paymentProcessorService;
    private final ShipmentProcessorService shipmentProcessorService;
    private final NotificationProcessorService notificationProcessorService;

    @Override
    public Mono<PlaceOrderResponseDTO> placeOrder(PlaceOrderRequestDTO requestDTO) {

        // 1. take order
        return orderProcessorService.order()
                // 2. make payment
                .flatMap(orderResult -> paymentProcessorService.pay(new PSChargingRequestDTO(orderResult.orderId())))
                // 3. create shipment
                .flatMap(paymentResult -> shipmentProcessorService.ship(new SSShippingRequestDTO(paymentResult.transactionId())))
                // 4. notify purchase
                .flatMap(shipmentResult -> notificationProcessorService.notify(new NSSendingRequestDTO(shipmentResult.trackingId())))
                .map(notificationResult -> new PlaceOrderResponseDTO("", "", "", ""));
    }
}
