package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Ingredient;
import com.cafesync.CafeSync.service.IngredientService;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public String getAllIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "ingredients";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "add-ingredient";
    }

    @PostMapping("/save")
    public String saveIngredient(@ModelAttribute Ingredient ingredient) {
        ingredientService.saveIngredient(ingredient);
        return "redirect:/ingredients";
    }
}