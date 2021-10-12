package com.recipeproject.recipeproject.repositories;

import com.recipeproject.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
