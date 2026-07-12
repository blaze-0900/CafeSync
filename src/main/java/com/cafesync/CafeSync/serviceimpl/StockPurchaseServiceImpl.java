package com.cafesync.CafeSync.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafesync.CafeSync.entity.StockPurchase;
import com.cafesync.CafeSync.repository.StockPurchaseRepository;
import com.cafesync.CafeSync.service.StockPurchaseService;

@Service
public class StockPurchaseServiceImpl implements StockPurchaseService {

    @Autowired
    private StockPurchaseRepository stockPurchaseRepository;

    @Override
    public StockPurchase saveStockPurchase(StockPurchase stockPurchase) {
        return stockPurchaseRepository.save(stockPurchase);
    }

    @Override
    public List<StockPurchase> getAllStockPurchases() {
        return stockPurchaseRepository.findAll();
    }

    @Override
    public Optional<StockPurchase> getStockPurchaseById(Long id) {
        return stockPurchaseRepository.findById(id);
    }

    @Override
    public StockPurchase updateStockPurchase(StockPurchase stockPurchase) {
        return stockPurchaseRepository.save(stockPurchase);
    }

    @Override
    public void deleteStockPurchase(Long id) {
        stockPurchaseRepository.deleteById(id);
    }
}