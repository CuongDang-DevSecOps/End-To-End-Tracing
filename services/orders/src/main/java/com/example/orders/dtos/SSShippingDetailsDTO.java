package com.example.orders.dtos;

public record SSShippingDetailsDTO(String trackingId, String orderId, String status, String shippedAt) {
}
