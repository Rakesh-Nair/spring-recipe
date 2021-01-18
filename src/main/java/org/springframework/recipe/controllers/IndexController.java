package org.springframework.recipe.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.recipe.domain.Category;
import org.springframework.recipe.domain.UnitOfMeasure;
import org.springframework.recipe.repository.CategoryRepository;
import org.springframework.recipe.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UnitOfMeasureRepository unitOfMeasureRepository;

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String getIndexPage() {
		Optional<Category> categoryOptional = categoryRepository.findByDescription("Indian");
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		System.out.println("ID is " + categoryOptional.get().getId());
		System.out.println("ID is " + uomOptional.get().getId());
		return "index";
	}
}
