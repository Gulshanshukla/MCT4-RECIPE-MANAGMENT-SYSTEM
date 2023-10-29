package com.geekster.Recipe.Management.System.API.repo;

import com.geekster.Recipe.Management.System.API.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IReciperepo extends JpaRepository<Recipe,Long> {
    @Query("SELECT r FROM Recipe r WHERE r.recipeIngredients IN :recipeIngredients")


    List<Recipe> findByRecipeIngredientsIn(@Param("recipeIngredients") List<String> ingredients);

    List<Recipe> findByRecipeNameContainingIgnoreCase(String name);
}
