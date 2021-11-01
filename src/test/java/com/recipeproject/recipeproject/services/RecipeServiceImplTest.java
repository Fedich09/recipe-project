package com.recipeproject.recipeproject.services;

import com.recipeproject.recipeproject.domain.Recipe;
import com.recipeproject.recipeproject.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;
    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        when(recipeRepository.findAll()).thenReturn(recipes);
        assertEquals(recipeService.getRecipes().size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}