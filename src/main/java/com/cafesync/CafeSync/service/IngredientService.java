package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Ingredient;

public interface IngredientService {

    Ingredient saveIngredient(Ingredient ingredient);

    List<Ingredient> getAllIngredients();

    Optional<Ingredient> getIngredientById(Long id);

    Ingredient updateIngredient(Ingredient ingredient);

    void deleteIngredient(Long id);
}