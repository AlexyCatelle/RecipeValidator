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

public class Category {
    private UUID id;
    @NotNull(message = "Ce champs doit être rempli !")
    private String name;
    @NotNull(message = "Ce champs doit être rempli !")
    private String description;
}
