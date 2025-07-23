package org.example.springvalidator.interfaces;

import org.example.springvalidator.model.dto.RecipeDTO;
import org.example.springvalidator.model.entity.Recipe;

import java.util.UUID;
import java.util.List;

public interface IRecipeService {
List<RecipeDTO> getAllRecipes();
}
