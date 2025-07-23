package org.example.springvalidator.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull(message = "Ce champs doit être rempli !")
    @NotBlank
    @Size(min = 3, max = 20, message = "Ce champs doit contenir entre 3 et 20 caracteres !")
    private String name;
    private String instructions;
    private String ingredients;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private  Category category;
}
