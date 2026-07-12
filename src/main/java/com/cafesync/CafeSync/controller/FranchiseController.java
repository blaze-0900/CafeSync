package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Franchise;
import com.cafesync.CafeSync.service.FranchiseService;

@Controller
@RequestMapping("/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @GetMapping
    public String getAllFranchises(Model model) {
        model.addAttribute("franchises", franchiseService.getAllFranchises());
        return "franchises";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("franchise", new Franchise());
        return "add-franchise";
    }

    @PostMapping("/save")
    public String saveFranchise(@ModelAttribute Franchise franchise) {
        franchiseService.saveFranchise(franchise);
        return "redirect:/franchises";
    }
}