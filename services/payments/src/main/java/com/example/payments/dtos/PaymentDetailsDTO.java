package com.example.payments.dtos;

import com.example.payments.enums.PaymentChargingStatus;

public record PaymentDetailsDTO(String transactionId, String orderId, PaymentChargingStatus status, String purchasedAt) {
}
