package com.example.payments.dtos;

import com.example.payments.enums.PaymentChargingStatus;

public record PaymentChargingDTO(String transactionId, PaymentChargingStatus status) {
}
