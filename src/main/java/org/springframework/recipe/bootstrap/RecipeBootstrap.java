package org.springframework.recipe.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.recipe.domain.Category;
import org.springframework.recipe.domain.Difficulty;
import org.springframework.recipe.domain.Ingredient;
import org.springframework.recipe.domain.Notes;
import org.springframework.recipe.domain.Recipe;
import org.springframework.recipe.domain.UnitOfMeasure;
import org.springframework.recipe.repository.CategoryRepository;
import org.springframework.recipe.repository.RecipeRepository;
import org.springframework.recipe.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Component;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	private List<Recipe> getRecipes() {
		List<Recipe> recipes = new ArrayList<>();
		Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

		if (!eachUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

		if (!tableSpoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

		if (!teaSpoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

		if (!dashUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

		if (!pintUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

		if (!cupsUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}

		UnitOfMeasure eachUom = eachUomOptional.get();
		UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
		UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
		UnitOfMeasure dashUom = dashUomOptional.get();
		UnitOfMeasure pintUom = pintUomOptional.get();
		UnitOfMeasure cupsUom = cupsUomOptional.get();

		Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
		if (!americanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category not found");
		}

		Optional<Category> indianCategoryOptional = categoryRepository.findByDescription("Indian");
		if (!indianCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category not found");
		}

		Category americanCategory = americanCategoryOptional.get();
		Category indianCategory = indianCategoryOptional.get();

		Recipe guacRecipe = new Recipe();
		guacRecipe.setDescription("Spice Guacamole");
		guacRecipe.setCookTime(9);
		guacRecipe.setPrepTime(20);
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setDirections(
				"1. All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n"
						+ "2. The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off\n"
						+ "3. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");

		Notes guacRecipeNotes = new Notes();
		guacRecipeNotes.setRecipeNotes(
				"Once the pit is removed, just cut the avocado into chunks right inside the peel and use a spoon to scoop them out.\n"
						+ "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. ");
		guacRecipeNotes.setRecipe(guacRecipe);
		guacRecipe.setNotes(guacRecipeNotes);
		guacRecipe.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, guacRecipe));
		guacRecipe.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, guacRecipe));
		guacRecipe.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, guacRecipe));
		guacRecipe.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, guacRecipe));
		guacRecipe.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, guacRecipe));
		guacRecipe.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, guacRecipe));

		guacRecipe.getCategories().add(americanCategory);
		guacRecipe.getCategories().add(indianCategory);

		recipes.add(guacRecipe);

		Recipe tacos = new Recipe();
		tacos.setDescription("Tacos");
		tacos.setCookTime(9);
		tacos.setPrepTime(20);
		tacos.setDifficulty(Difficulty.EASY);
		tacos.setDirections(
				"1. All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n"
						+ "2. The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off\n"
						+ "3. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");

		Notes tacosNotes = new Notes();
		tacosNotes.setRecipeNotes(
				"Once the pit is removed, just cut the avocado into chunks right inside the peel and use a spoon to scoop them out.\n"
						+ "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. ");
		tacosNotes.setRecipe(tacos);
		tacos.setNotes(tacosNotes);
		tacos.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, tacos));
		tacos.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, tacos));
		tacos.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, tacos));
		tacos.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, tacos));
		tacos.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, tacos));
		tacos.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), eachUom, tacos));

		tacos.getCategories().add(americanCategory);

		recipes.add(tacos);
		return recipes;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<Recipe> recipes = getRecipes();
		recipeRepository.saveAll(recipes);
	}
}
