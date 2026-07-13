package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Recipe;
import com.cafesync.CafeSync.service.IngredientService;
import com.cafesync.CafeSync.service.ProductService;
import com.cafesync.CafeSync.service.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public String getAllRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("recipe", new Recipe());

        model.addAttribute("products", productService.getAllProducts());

        model.addAttribute("ingredients", ingredientService.getAllIngredients());

        return "add-recipe";
    }

    @PostMapping("/save")
    public String saveRecipe(@ModelAttribute Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return "redirect:/recipes";
    }
}