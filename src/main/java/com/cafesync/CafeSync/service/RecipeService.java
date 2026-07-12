package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Recipe;

public interface RecipeService {

    Recipe saveRecipe(Recipe recipe);

    List<Recipe> getAllRecipes();

    Optional<Recipe> getRecipeById(Long id);

    Recipe updateRecipe(Recipe recipe);

    void deleteRecipe(Long id);
}