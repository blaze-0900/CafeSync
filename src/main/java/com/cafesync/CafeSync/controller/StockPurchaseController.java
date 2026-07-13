package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Status;
import com.cafesync.CafeSync.entity.StockPurchase;
import com.cafesync.CafeSync.service.FranchiseService;
import com.cafesync.CafeSync.service.IngredientService;
import com.cafesync.CafeSync.service.StockPurchaseService;
import com.cafesync.CafeSync.service.SupplierService;

@Controller
@RequestMapping("/stockpurchase")
public class StockPurchaseController {

    @Autowired
    private StockPurchaseService stockPurchaseService;
    @Autowired
    private SupplierService supplierService;

    @Autowired
    private FranchiseService franchiseService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public String getAllStockPurchases(Model model) {
        model.addAttribute("stockPurchases", stockPurchaseService.getAllStockPurchases());
        return "stockpurchase";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("stockPurchase", new StockPurchase());

        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        model.addAttribute("franchises", franchiseService.getAllFranchises());
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        model.addAttribute("statuses", Status.values());

        return "add-stockpurchase";
    }

    @PostMapping("/save")
    public String saveStockPurchase(@ModelAttribute StockPurchase stockPurchase) {
        stockPurchaseService.saveStockPurchase(stockPurchase);
        return "redirect:/stockpurchase";
    }
}