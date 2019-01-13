package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "step")
public class Step {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "recipe_id")
	private int recipeId;

	@Column(name = "step_no")
	private int stepNo;

	@Column(name = "description")
	private String description;

	@Column(name = "picture")
	private String picture;

	@ManyToOne
	@JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Recipe recipe;

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getStepNo() {
		return stepNo;
	}

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
