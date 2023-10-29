package com.geekster.Recipe.Management.System.API.controller;

import com.geekster.Recipe.Management.System.API.model.Recipe;
import com.geekster.Recipe.Management.System.API.model.dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.System.API.service.Recipeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Validated

public class Recipecontroller {
    @Autowired
    Recipeservice recipeservice;
    @GetMapping("recipes")
    public List<Recipe> getAllRecipe(@RequestBody AuthenticationInputDto authInfo)
    {
        return recipeservice.getAllRecipes(authInfo);
    }
    @GetMapping("recipe/id/{id}")
    public Recipe getRecipeById(@PathVariable Long id)
    {
        return recipeservice.getRecipeById(id);
    }




}
