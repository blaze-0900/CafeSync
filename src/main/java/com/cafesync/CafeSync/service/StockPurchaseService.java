package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.StockPurchase;

public interface StockPurchaseService {

    StockPurchase saveStockPurchase(StockPurchase stockPurchase);

    List<StockPurchase> getAllStockPurchases();

    Optional<StockPurchase> getStockPurchaseById(Long id);

    StockPurchase updateStockPurchase(StockPurchase stockPurchase);

    void deleteStockPurchase(Long id);

}