package org.springframework.recipe.service;

import java.util.Set;

import org.springframework.recipe.domain.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipe();
}
