package org.example.springvalidator.interfaces;

import org.example.springvalidator.model.Category;
import org.example.springvalidator.model.Recipe;

import java.util.UUID;
import java.util.List;

public interface IRecipeService {
    Recipe createRecipe (Recipe recipe);
    Recipe getRecipeById (UUID id);
//    List<Recipe> getRecipesByCategory (Category category);
    List<Recipe> getAllRecipes ();
    Recipe updateRecipe (UUID id, Recipe recipe);
    void deleteRecipe (UUID id);

}
