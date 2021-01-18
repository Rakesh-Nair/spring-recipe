package org.springframework.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	Optional<UnitOfMeasure> findByDescription(String description);
}
