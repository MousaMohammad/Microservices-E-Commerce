package com.mousatech.inventoryservice.service;

import com.mousatech.inventoryservice.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Transactional
    public boolean isInStock(String sku) {
        return inventoryRepo.findBySku(sku).isPresent();
    }
}
