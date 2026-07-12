package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.StockPurchase;
import com.cafesync.CafeSync.service.StockPurchaseService;

@Controller
@RequestMapping("/stockpurchase")
public class StockPurchaseController {

    @Autowired
    private StockPurchaseService stockPurchaseService;

    @GetMapping
    public String getAllStockPurchases(Model model) {
        model.addAttribute("stockPurchases", stockPurchaseService.getAllStockPurchases());
        return "stockpurchase";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("stockPurchase", new StockPurchase());
        return "add-stockpurchase";
    }

    @PostMapping("/save")
    public String saveStockPurchase(@ModelAttribute StockPurchase stockPurchase) {
        stockPurchaseService.saveStockPurchase(stockPurchase);
        return "redirect:/stockpurchase";
    }
}