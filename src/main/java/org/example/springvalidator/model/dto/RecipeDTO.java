package org.example.springvalidator.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RecipeDTO {
    private UUID id;
    private String name;
    private String instructions;
    private String ingredients;
}
