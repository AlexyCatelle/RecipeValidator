package org.example.springvalidator.service;

import org.example.springvalidator.interfaces.ICategoryService;
import org.example.springvalidator.model.Category;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CategoryService implements ICategoryService {

    private final Map<UUID, Category> categories;

    public CategoryService() {
        categories = new HashMap<>();
        initCategories();
    }

    private void initCategories() {

    UUID catDessertId = UUID.fromString("09aa20b5-d294-4812-b341-25fa9e9a8dcb");
    UUID catEntreeId = UUID.fromString("a68879f6-636f-4436-b60c-b08831321a04");
    UUID catPlatId = UUID.fromString("91cef8d1-2bd5-43f3-ac90-bd01f984e8b5");

    Category dessert = new Category(
            catDessertId,
            "Dessert",
            "Dessert sucré ou salé."
    );

    Category entree = new Category(
            catEntreeId,
            "Entrée",
            "Entrée chaude ou froide."
    );

    Category plat = new Category(
            catPlatId,
            "Plat principal",
            "plat chaud ou froid."
    );

    categories.put(catDessertId, dessert);
    categories.put(catEntreeId, entree);
    categories.put(catPlatId, plat);
    }


    @Override
    public Category createCategory(Category category) {
        category.setId(UUID.randomUUID());
        categories.put(category.getId(), category);
        return category;
    }

    @Override
    public Category getCategoryById(UUID id) {
       return categories.get(id);
    }

    @Override
    public List<Category> getAllCategories(){
     return categories.values().stream().toList();
    }

    @Override
    public Category updateCategory (UUID id, Category category) {
        Category updateCategory = categories.get(id);

        if(updateCategory == null) {
            return null;
        }

        if (!updateCategory.getName().isBlank())
            updateCategory.setName(updateCategory.getName());

        if (!updateCategory.getDescription().isBlank())
            updateCategory.setDescription(updateCategory.getDescription());

        return categories.put(id, updateCategory);
    }

    @Override
    public void deleteCategory (UUID id) {
       categories.remove(id);
    }

}
