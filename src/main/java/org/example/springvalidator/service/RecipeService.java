package org.example.springvalidator.service;

import org.example.springvalidator.interfaces.IRecipeService;
import org.example.springvalidator.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService implements IRecipeService {
    private final Map<UUID, Recipe> recipes;

    public RecipeService() {
        recipes = new HashMap<>();

    }
    @Override
    public Recipe createRecipe(Recipe recipe) {
        recipe.setId(UUID.randomUUID());
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }
}
