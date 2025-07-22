package org.example.springvalidator.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private UUID id;
    @NotNull(message = "Ce champs doit être rempli !")
    @NotBlank
    @Size(min = 3, max = 20, message = "Ce champs doit contenir entre 3 et 20 caracteres !")
    private String name;
    private UUID categoryId;
    private String instructions;
    private List<Recipe> ingredients;
}
