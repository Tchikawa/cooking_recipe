package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RecipeRepository;
import com.example.demo.entity.Recipe;

/**
 * リクエストをさばく
 **/
@Controller
public class RecipesController {
	@Autowired
	RecipeRepository recipeRepository;

	@RequestMapping("/")
	private String recipes(Model model) {
		List<Recipe> recipeList = recipeRepository.findAll();
		model.addAttribute("recipeList", recipeList);
		return "recipes";
	}
}
