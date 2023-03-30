package com.example.inventories.controllers;

import com.example.inventories.dtos.InventoryOrderingDTO;
import com.example.inventories.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public InventoryOrderingDTO proceedOrder() {
        return inventoryService.proceedOrder();

    }
}
