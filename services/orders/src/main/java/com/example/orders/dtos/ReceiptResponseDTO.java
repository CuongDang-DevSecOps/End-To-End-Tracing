package com.example.orders.dtos;

public record ReceiptResponseDTO(OrderDetails order, PaymentDetails payment, ShipmentDetails shipment) {

    public record OrderDetails(String orderId, String status, String orderedAt) {
    }

    public record PaymentDetails(String transactionId, String orderId, String status, String purchasedAt) {
    }

    public record ShipmentDetails(String trackingId, String orderId, String status, String shippedAt) {
    }
}


