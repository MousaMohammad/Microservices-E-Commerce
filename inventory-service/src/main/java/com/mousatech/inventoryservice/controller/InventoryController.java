package com.mousatech.inventoryservice.controller;

import com.mousatech.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{sku}")
    @ResponseStatus(code = HttpStatus.OK)
    public boolean isInStock(@PathVariable String sku) {
        return inventoryService.isInStock(sku);
    }
}
