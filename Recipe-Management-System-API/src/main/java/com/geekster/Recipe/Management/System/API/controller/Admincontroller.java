package com.geekster.Recipe.Management.System.API.controller;

import com.geekster.Recipe.Management.System.API.model.Recipe;
import com.geekster.Recipe.Management.System.API.model.User;
import com.geekster.Recipe.Management.System.API.service.Recipeservice;
import com.geekster.Recipe.Management.System.API.service.Userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Admincontroller {
    @Autowired
    Recipeservice recipeservice;
    @Autowired
    Userservice userservice;
    @GetMapping("users")
    public List<User> getAllUsers()
    {
        return userservice.getAllUsers();
    }
    @PostMapping("recipes")
    public String addRecipes(@Valid @RequestBody Recipe newrecipes)
    {
        return recipeservice.addRecipes(newrecipes);
    }
    @DeleteMapping("delete/recipe/id/{id}")

        public String deleteRecipeById(@RequestParam Long Id)
        {
           return recipeservice.deleteRecipeByID(Id);
        }
    @PutMapping("/updateRecipe")
    public String updateRecipe(@Valid @RequestBody Recipe updatedRecipe) {
        return recipeservice.updateRecipe(updatedRecipe);
    }
    @GetMapping("admin/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeservice.getAllRecipesByAdmin();
    }





}
