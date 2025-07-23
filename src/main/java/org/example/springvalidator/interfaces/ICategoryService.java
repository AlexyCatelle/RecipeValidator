package org.example.springvalidator.interfaces;

import org.example.springvalidator.model.entity.Category;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    Category createCategory (Category category);
    Category getCategoryById (UUID id);
    List<Category> getAllCategories();
    Category updateCategory (UUID id,Category recipe);
    void deleteCategory (UUID id);
}
