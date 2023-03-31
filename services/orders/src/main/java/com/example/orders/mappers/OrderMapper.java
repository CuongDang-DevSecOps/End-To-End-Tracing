package com.example.orders.mappers;

import com.example.orders.dtos.*;
import com.example.orders.enums.PlaceOrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderId", source = "orderingResult.orderId")
    @Mapping(target = "transactionId", source = "paymentResult.transactionId")
    @Mapping(target = "trackingId", source = "shipmentResult.trackingId")
    @Mapping(target = "status", source = "status")
    PlaceOrderResponseDTO toPlaceOrderResponse(ISOrderingResultResponseDTO orderingResult,
                                               PSChargingResultResponseDTO paymentResult,
                                               SSShippingResultResponseDTO shipmentResult,
                                               PlaceOrderStatus status);

    ReceiptResponseDTO.OrderDetails toOrderDetails(ISOrderDetailsDTO orderDetails);

    ReceiptResponseDTO.PaymentDetails toPaymentDetails(PSPaymentDetailsDTO paymentDetails);

    ReceiptResponseDTO.ShipmentDetails toShipmentDetails(SSShippingDetailsDTO shippingDetails);

    ReceiptResponseDTO toReceiptResponse(ISOrderDetailsDTO order,
                                         PSPaymentDetailsDTO payment,
                                         SSShippingDetailsDTO shipment);
}
