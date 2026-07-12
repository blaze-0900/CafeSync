package com.cafesync.CafeSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafesync.CafeSync.entity.StockPurchase;

@Repository
public interface StockPurchaseRepository extends JpaRepository<StockPurchase, Long> {
}
