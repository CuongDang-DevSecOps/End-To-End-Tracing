package com.example.shipments.dtos;

import com.example.shipments.enums.ShippingStatus;

public record ShippingDTO(String trackingId, ShippingStatus status) {
}
