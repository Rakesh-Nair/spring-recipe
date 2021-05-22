package org.springframework.recipe.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.recipe.service.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		log.debug("Fetching Index");
		return "index";
	}
}
