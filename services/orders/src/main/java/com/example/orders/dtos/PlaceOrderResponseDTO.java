package com.example.orders.dtos;

public record PlaceOrderResponseDTO(String orderId, String trackingId, String transactionId, String status) {
}
