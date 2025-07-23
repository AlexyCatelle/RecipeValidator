package org.example.springvalidator.mapper;

import org.example.springvalidator.model.dto.RecipeDTO;
import org.example.springvalidator.model.dto.RecipeWithCategoryDTO;
import org.example.springvalidator.model.entity.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipeMapper {
    public RecipeDTO recipeToRecipeDTO(Recipe recipe) {
        return new RecipeDTO(recipe.getId(),recipe.getName(),recipe.getInstructions(),recipe.getIngredients());
    }

    public RecipeWithCategoryDTO recipeToRecipeWithCategoryDTO(Recipe recipe) {
        return new RecipeWithCategoryDTO(recipe.getName(),recipe.getInstructions(), recipe.getIngredients(), recipe.getCategory());
    }

    public Recipe recipeWithCategoryDTOoRecipe(RecipeWithCategoryDTO recipeDTO){
        return Recipe.builder()
                .name(recipeDTO.getName())
                .instructions(recipeDTO.getInstructions())
                .ingredients(recipeDTO.getIngredients())
                .category(recipeDTO.getCategory())
                .build();

    }
}
