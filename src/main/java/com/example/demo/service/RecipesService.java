package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.RecipeRepository;
import com.example.demo.entity.Recipe;

@Service
public class RecipesService {
	@Autowired
	RecipeRepository repository;

	public List<Recipe> findRecipes(String searchWord) {
		List<Recipe> result;

		if (null == searchWord || "" == searchWord) {
			result = repository.findAll();
		} else {
			result = repository.findRecipe(searchWord);
		}
		return result;
	}

	public Recipe findRecipe(int id) {
//		return repository.findSteps(id);
		return repository.getOne(id);
	}

}
