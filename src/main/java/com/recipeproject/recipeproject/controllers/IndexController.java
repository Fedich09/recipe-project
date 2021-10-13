package com.recipeproject.recipeproject.controllers;

import com.recipeproject.recipeproject.domain.Category;
import com.recipeproject.recipeproject.domain.UnitOfMeasure;
import com.recipeproject.recipeproject.repositories.CategoryRepository;
import com.recipeproject.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Pinch");
        System.out.println(category.get().getId());
        System.out.println(unitOfMeasure.get().getId());
        return "index";

    }
}
