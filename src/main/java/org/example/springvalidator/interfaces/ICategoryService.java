package org.example.springvalidator.interfaces;

import org.example.springvalidator.model.Category;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    Category createCategory (Category category);
    Category getCategoryById (UUID id);
    List<Category> getAllCategory();
    Category updateCategory (UUID id,Category recipe);
    void deleteCategory (UUID id);
}
