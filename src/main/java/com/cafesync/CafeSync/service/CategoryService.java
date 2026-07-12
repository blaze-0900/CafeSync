package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Category;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Category updateCategory(Category category);

    void deleteCategory(Long id);
}
