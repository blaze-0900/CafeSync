package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Inventory;

public interface InventoryService {

    Inventory saveInventory(Inventory inventory);

    List<Inventory> getAllInventory();

    Optional<Inventory> getInventoryById(Long id);

    Inventory updateInventory(Inventory inventory);

    void deleteInventory(Long id);

}