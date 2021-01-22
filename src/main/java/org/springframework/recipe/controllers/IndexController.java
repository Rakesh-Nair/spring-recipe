package org.springframework.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.recipe.service.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Autowired
	private RecipeServiceImpl recipeService;

	public IndexController(RecipeServiceImpl recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", recipeService.getRecipe());
		return "index";
	}
}
