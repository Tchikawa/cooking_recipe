package com.example.demo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	@Query("SELECT r FROM Recipe r WHERE r.title LIKE %:searchWord% OR r.description LIKE %:searchWord% ")
	public List<Recipe> findRecipe(@Param("searchWord") String searchWord);

//	@Query("SELECT d FROM Step d WHERE d.recipeId = :id")
//	public List<Step> findDetail(@Param("id") int id);

//	@Query("SELECT r.id as id, r.title as title, r.description as recipeDescription, " +
//	"d.stepNo as stepNo, d.description as detailDescription, d.picture as picture " +
//			"FROM Recipe r INNER JOIN Step d ON r.id = d.recipeId WHERE r.id = :id")
//	public Recipe findSteps(@Param("id") int id);



}
