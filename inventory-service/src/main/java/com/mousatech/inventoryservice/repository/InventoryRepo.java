package com.mousatech.inventoryservice.repository;

import com.mousatech.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySku(String sku);
}
