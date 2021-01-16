package org.springframework.recipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}
