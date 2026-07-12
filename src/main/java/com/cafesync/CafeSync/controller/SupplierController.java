package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Supplier;
import com.cafesync.CafeSync.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public String getAllSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "suppliers";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "add-supplier";
    }

    @PostMapping("/save")
    public String saveSupplier(@ModelAttribute Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }
}