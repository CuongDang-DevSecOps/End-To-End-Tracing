package com.example.orders.dtos;

public record PSPaymentDetailsDTO(String transactionId, String orderId, String status, String purchasedAt) {
}
