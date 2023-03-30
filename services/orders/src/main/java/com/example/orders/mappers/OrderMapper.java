package com.example.orders.mappers;

import com.example.orders.dtos.ISOrderingResultResponseDTO;
import com.example.orders.dtos.PSChargingResultResponseDTO;
import com.example.orders.dtos.PlaceOrderResponseDTO;
import com.example.orders.dtos.SSShippingResultResponseDTO;
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
}
