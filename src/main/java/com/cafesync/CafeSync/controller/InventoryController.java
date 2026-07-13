package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Inventory;
import com.cafesync.CafeSync.entity.Status;
import com.cafesync.CafeSync.service.FranchiseService;
import com.cafesync.CafeSync.service.IngredientService;
import com.cafesync.CafeSync.service.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private FranchiseService franchiseService;
    @Autowired
    private IngredientService ingredientService;
    


    @GetMapping
    public String getAllInventory(Model model) {
        model.addAttribute("inventory", inventoryService.getAllInventory());
        return "inventory";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("inventory", new Inventory());

        model.addAttribute("franchises", franchiseService.getAllFranchises());

        model.addAttribute("ingredients", ingredientService.getAllIngredients());

        model.addAttribute("statuses", Status.values());

        return "add-inventory";
    }

    @PostMapping("/save")
    public String saveInventory(@ModelAttribute Inventory inventory) {
        inventoryService.saveInventory(inventory);
        return "redirect:/inventory";
    }
}