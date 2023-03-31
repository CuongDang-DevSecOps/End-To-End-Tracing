package com.example.inventories.dtos;

import com.example.inventories.enums.InventoryOrderingStatus;

public record OrderDetailsDTO(String orderId, InventoryOrderingStatus status, String orderedAt) {
}
