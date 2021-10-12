package com.recipeproject.recipeproject.repositories;

import com.recipeproject.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
