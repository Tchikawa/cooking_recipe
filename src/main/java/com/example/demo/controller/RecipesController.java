package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Step;
import com.example.demo.entity.Recipe;
import com.example.demo.service.RecipesService;

/**
 * リクエストをさばく
 **/
@Controller
@RequestMapping("/")
public class RecipesController {
	@Autowired
	RecipesService service;

	@RequestMapping(method = RequestMethod.GET)
	private String index(Model model) {
		List<Recipe> recipeList = service.findRecipes(null);
		model.addAttribute("recipeList", recipeList);
		return "recipes";
	}

	@RequestMapping(method = RequestMethod.POST)
	private String recipes(@RequestParam("serchWord") String searchWord, Model model) {
		List<Recipe> recipeList = service.findRecipes(searchWord);
		model.addAttribute(recipeList);
		return "recipes";
	}

	@RequestMapping(value = "detail")
	private String detail(@RequestParam("id") String id, Model model) {
		Recipe recipe = service.findRecipe(Integer.parseInt(id));
		List<Step> stepList = recipe.getStepList();
		model.addAttribute("recipe", recipe);
		model.addAttribute("stepList", stepList);
		return "detail";
	}
}