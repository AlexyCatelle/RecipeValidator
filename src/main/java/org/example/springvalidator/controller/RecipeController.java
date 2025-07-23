package org.example.springvalidator.controller;

import org.example.springvalidator.interfaces.ICategoryService;
import org.example.springvalidator.interfaces.IRecipeService;
import org.example.springvalidator.model.entity.Recipe;
import org.example.springvalidator.model.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class RecipeController {

    private IRecipeService recipeService;
    private ICategoryService categoryService;

    public RecipeController(IRecipeService recipeService, ICategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("home")
    public String home(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        List <Category> categories =categoryService.getAllCategories();
        Map<UUID, String> categoryMap = categories.stream()
                .collect(Collectors.toMap(Category::getId, Category::getName));

        model.addAttribute("categories", categoryMap);
        return "home";
    }

    @GetMapping("/recipes/add")
    public String addRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        List <Category> categories =categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "Recipe/newRecipeForm";
    }

    @PostMapping("/recipes/add")
    public String addRecipe (Recipe recipe){
        if(recipe != null){
            recipeService.createRecipe(recipe);
        }
        return "redirect:/home";
    }

    @GetMapping("/recipes/detail/{id}")
    public String getRecipe (@PathVariable("id") UUID id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "Recipe/recipeDetails";
    }

    @GetMapping("/recipes/delete/{id}")
    public String deleteRecipe (@PathVariable("id") UUID id, Model model) {
        recipeService.deleteRecipe(id);
        return "redirect:/home";
    }

    @GetMapping("/recipes/update/{id}")
public String updateRecipe (@PathVariable("id") UUID id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "Recipe/updateRecipeForm";
    }

    @PostMapping("/recipes/update")
    public String updateRecipe(Recipe recipe){
        if(recipe.getId() != null)
            recipeService.updateRecipe(recipe.getId(), recipe);
        return "redirect:/recipes/detail/{id}";
    }

}
