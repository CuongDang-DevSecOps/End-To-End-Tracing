package com.example.orders.dtos;

public record PlaceOrderResponseDTO(String orderId, String transactionId, String trackingId, String status) {
}
