package com.example.inventories.dtos;

import com.example.inventories.enums.InventoryOrderingStatus;

public record InventoryOrderingDTO(String orderId, InventoryOrderingStatus status) {
}
