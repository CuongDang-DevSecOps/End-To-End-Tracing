package com.example.shipments.dtos;

import com.example.shipments.enums.ShippingStatus;

public record ShippingDetailsDTO(String trackingId, String orderId, ShippingStatus status, String shippedAt) {
}
