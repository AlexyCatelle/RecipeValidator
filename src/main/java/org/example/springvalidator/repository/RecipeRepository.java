package org.example.springvalidator.repository;

import org.example.springvalidator.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
}
