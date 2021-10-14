package com.recipeproject.recipeproject.services;

import com.recipeproject.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
