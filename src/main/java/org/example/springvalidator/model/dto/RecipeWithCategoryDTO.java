package org.example.springvalidator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springvalidator.model.entity.Category;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeWithCategoryDTO {
    private String name;
    private String instructions;
    private String ingredients;
    private Category category;
}

