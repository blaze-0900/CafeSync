package com.cafesync.CafeSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafesync.CafeSync.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}