package com.recipeproject.recipeproject.bootstrap;

import com.recipeproject.recipeproject.domain.Difficulty;
import com.recipeproject.recipeproject.domain.Ingredient;
import com.recipeproject.recipeproject.domain.Notes;
import com.recipeproject.recipeproject.domain.Recipe;
import com.recipeproject.recipeproject.repositories.CategoryRepository;
import com.recipeproject.recipeproject.repositories.RecipeRepository;
import com.recipeproject.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public DataBootstrap(RecipeRepository recipeRepository,
                         UnitOfMeasureRepository unitOfMeasureRepository,
                         CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Recipe theBestGuacamole = new Recipe();
        theBestGuacamole.setDescription("The word \"guacamole\" and the dip, are both originally from Mexico, " +
                "where avocados have been cultivated for thousands of years. " +
                "The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).");
        theBestGuacamole.setPrepTime(10);
        theBestGuacamole.setCookTime(10);
        theBestGuacamole.setSource("Simply recipes");
        theBestGuacamole.setUrl("https://www.simplyrecipes.com/");
        theBestGuacamole.setDirection("forward");
        theBestGuacamole.setDifficulty(Difficulty.MODERATE);

        Ingredient avocado = new Ingredient();
        avocado.setAmount(BigDecimal.valueOf(2));
        avocado.setRecipe(theBestGuacamole);
        avocado.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Ripe").orElseThrow());
        Ingredient salt = new Ingredient();
        salt.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").orElseThrow());
        salt.setAmount(BigDecimal.valueOf(0.25));
        salt.setRecipe(theBestGuacamole);
        Ingredient freshLime = new Ingredient();
        freshLime.setAmount(BigDecimal.valueOf(1));
        freshLime.setRecipe(theBestGuacamole);
        freshLime.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").orElseThrow());

        theBestGuacamole.getIngredients().add(avocado);
        theBestGuacamole.getIngredients().add(salt);
        theBestGuacamole.getIngredients().add(freshLime);

        Notes notes = new Notes();
        notes.setRecipeNotes("Be careful handling chilis! If using, it's best to wear food-safe gloves." +
                " If no gloves are available, wash your hands thoroughly after handling, " +
                "and do not touch your eyes or the area near your eyes for several hours afterwards.");
        notes.setRecipe(theBestGuacamole);

        theBestGuacamole.setNotes(notes);

        theBestGuacamole.getCategories().add(categoryRepository.findByDescription("American").orElseThrow());
        theBestGuacamole.getCategories().add(categoryRepository.findByDescription("Fast Food").orElseThrow());

        recipeRepository.save(theBestGuacamole);
    }
}
