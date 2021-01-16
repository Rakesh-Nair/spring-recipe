package org.springframework.recipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
