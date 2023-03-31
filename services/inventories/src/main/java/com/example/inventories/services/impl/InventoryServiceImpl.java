package com.example.inventories.services.impl;

import com.example.inventories.dtos.InventoryOrderingDTO;
import com.example.inventories.dtos.OrderDetailsDTO;
import com.example.inventories.enums.InventoryOrderingStatus;
import com.example.inventories.services.InventoryService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Override
    public InventoryOrderingDTO proceedOrder() {
        // validate order
        // decrease stock
        return new InventoryOrderingDTO(UUID.randomUUID().toString(), InventoryOrderingStatus.ORDERED);
    }

    @Override
    public OrderDetailsDTO retrieveOrderDetails(String orderId) {
        return new OrderDetailsDTO(
                orderId,
                InventoryOrderingStatus.ORDERED,
                ZonedDateTime.now().toOffsetDateTime().toString());
    }
}
