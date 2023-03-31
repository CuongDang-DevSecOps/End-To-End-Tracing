package com.example.orders.facades.impl;

import com.example.orders.dtos.*;
import com.example.orders.enums.PlaceOrderStatus;
import com.example.orders.facades.OrderFacade;
import com.example.orders.mappers.OrderMapper;
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
    private final OrderMapper orderMapper;

    @Override
    public Mono<PlaceOrderResponseDTO> placeOrder(PlaceOrderRequestDTO requestDTO) {

        // 1. take order
        // 2. make payment
        // 3. create shipment
        // 4. notify purchase
        // 5. fulfill result
        return orderProcessorService.order()
                .flatMap(orderResult -> paymentProcessorService.pay(new PSChargingRequestDTO(orderResult.orderId()))
                        .flatMap(paymentResult -> shipmentProcessorService.ship(new SSShippingRequestDTO(paymentResult.transactionId()))
                                .flatMap(shipmentResult -> notificationProcessorService.notify(new NSSendingRequestDTO(shipmentResult.trackingId()))
                                        .map(responseDTO -> orderMapper.toPlaceOrderResponse(orderResult, paymentResult, shipmentResult, PlaceOrderStatus.SUCCEED)))));
    }
}
