package org.springframework.recipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
