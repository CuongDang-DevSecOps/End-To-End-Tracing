package com.example.inventories.services;

import com.example.inventories.dtos.InventoryOrderingDTO;
import com.example.inventories.dtos.OrderDetailsDTO;

public interface InventoryService {

    InventoryOrderingDTO proceedOrder();

    OrderDetailsDTO retrieveOrderDetails(String orderId);
}
