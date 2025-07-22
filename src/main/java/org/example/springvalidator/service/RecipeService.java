package org.example.springvalidator.service;

import org.example.springvalidator.interfaces.IRecipeService;
import org.example.springvalidator.model.Category;
import org.example.springvalidator.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService implements IRecipeService {
    private final Map<UUID, Recipe> recipes;

    public RecipeService() {
        recipes = new HashMap<>();
        initRecipes();
    }

    private void initRecipes() {
        UUID catDessert = UUID.fromString("09aa20b5-d294-4812-b341-25fa9e9a8dcb");
        UUID catEntree = UUID.fromString("a68879f6-636f-4436-b60c-b08831321a04");
        UUID catPlat = UUID.fromString("91cef8d1-2bd5-43f3-ac90-bd01f984e8b5");

        Recipe gateau = new Recipe(
                UUID.randomUUID(),
                "Gâteau",
                catDessert,
                "Mélanger les ingrédients, cuire 30 minutes à 180°C.",
                "sucre, farine, œufs, levure"
        );

        Recipe pasta = new Recipe(
                UUID.randomUUID(),
                "Pâtes Carbonara",
                catPlat,
                "Cuire les pâtes, ajouter les lardons et la crème fraîche. Servir chaud.",
                "pâtes, lardons, crème fraîche, sel, poivre"
        );

        Recipe salade = new Recipe(
                UUID.randomUUID(),
                "Salade César",
                catPlat,
                "Mélanger les ingrédients, ajouter la sauce César, et servir frais.",
                "laitue, poulet grillé, croûtons, parmesan, sauce César"
        );

        Recipe saladeChevre = new Recipe(
                UUID.randomUUID(),
                "Salade de chèvre chaud",
                catEntree,
                "Disposer les toasts de chèvre sur la salade, arroser de miel, puis passer au four 5 minutes.",
                "salade verte, fromage de chèvre, miel, pain, noix"
        );

        recipes.put(gateau.getId(), gateau);
        recipes.put(pasta.getId(), pasta);
        recipes.put(salade.getId(), salade);
        recipes.put(saladeChevre.getId(), saladeChevre);

    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        recipe.setId(UUID.randomUUID());
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipeById (UUID id) {return recipes.get(id);}

    @Override
    public List<Recipe> getAllRecipes () { return recipes.values().stream().toList();}

    @Override
    public Recipe updateRecipe (UUID id, Recipe recipe) {
        Recipe recipeToUpdate = recipes.get(id);

        if (recipeToUpdate == null) {
            return null;
        }

        if(!recipeToUpdate.getName().isBlank())
            recipeToUpdate.setName(recipeToUpdate.getName());

        if(recipeToUpdate.getCategoryId() != null)
            recipeToUpdate.setCategoryId(recipeToUpdate.getCategoryId());

        if(!recipeToUpdate.getInstructions().isBlank())
            recipeToUpdate.setInstructions(recipeToUpdate.getInstructions());

        if(!recipeToUpdate.getIngredients().isEmpty())
            recipeToUpdate.setIngredients(recipeToUpdate.getIngredients());

        return recipes.put(id,recipeToUpdate);
    }

    @Override
    public void deleteRecipe (UUID id) {recipes.remove(id);}


}
