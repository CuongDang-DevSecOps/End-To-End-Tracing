package com.example.inventories.services.impl;

import com.example.inventories.dtos.InventoryOrderingDTO;
import com.example.inventories.enums.InventoryOrderingStatus;
import com.example.inventories.services.InventoryService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Override
    public InventoryOrderingDTO proceedOrder() {
        // validate order
        // decrease stock
        return new InventoryOrderingDTO(UUID.randomUUID().toString(), InventoryOrderingStatus.ORDERED);
    }
}
