package org.example.springvalidator.controller;

import org.example.springvalidator.interfaces.IRecipeService;
import org.example.springvalidator.model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RecipeController {

    private IRecipeService recipeService;

    public RecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("home")
    public String home(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "home";
    }

    @GetMapping("/recipe/add")
    public String addRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipe/NewRecipeForm";
    }

    @PostMapping("/recipe/add")
    public String addRecipe (Recipe recipe){
        if(recipe != null){
            recipeService.createRecipe(recipe);
        }
        return "redirect:/home";
    }


}
