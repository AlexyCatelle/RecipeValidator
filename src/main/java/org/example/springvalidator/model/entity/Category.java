package org.example.springvalidator.model.entity;


import jakarta.persistence.*;
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

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull(message = "Ce champs doit être rempli !")
    private String name;
    @NotNull(message = "Ce champs doit être rempli !")
    private String description;

    @OneToMany(mappedBy ="category")
    private List<Recipe> recipes;
}
