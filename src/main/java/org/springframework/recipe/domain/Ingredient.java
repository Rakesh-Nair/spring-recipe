package org.springframework.recipe.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	@ManyToOne
	private Recipe recipe;
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure unit;

	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingredient(Long id, String description, BigDecimal amount, Recipe recipe, UnitOfMeasure unit) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.recipe = recipe;
		this.unit = unit;
	}

	public Ingredient(String description, BigDecimal amount, UnitOfMeasure unit, Recipe recipe) {
		super();
		this.description = description;
		this.amount = amount;
		this.unit = unit;
		this.recipe = recipe;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * @return the unit
	 */
	public UnitOfMeasure getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(UnitOfMeasure unit) {
		this.unit = unit;
	}

}
