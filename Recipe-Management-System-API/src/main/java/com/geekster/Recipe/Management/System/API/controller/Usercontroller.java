package com.geekster.Recipe.Management.System.API.controller;

import com.geekster.Recipe.Management.System.API.model.Recipe;
import com.geekster.Recipe.Management.System.API.model.User;
import com.geekster.Recipe.Management.System.API.model.dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.System.API.model.dto.SignInInputDto;
import com.geekster.Recipe.Management.System.API.service.Recipeservice;
import com.geekster.Recipe.Management.System.API.service.Userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated

public class Usercontroller {
    @Autowired
    Userservice userservice;
    @Autowired
    Recipeservice recipeservice;
    //signup or register
    //signin
    //signout
    @PostMapping("user/register")
    public String userSignUp(@Valid @RequestBody User user)
    {
        return userservice.userSignUp(user);

    }
    @PostMapping("user/Login")
    public String userSignIn(@Valid @RequestBody SignInInputDto signInInputDto)
    {
        return userservice.userSignIn(signInInputDto);


    }
    @DeleteMapping("user/signout")
    public String userSignOut(@RequestBody AuthenticationInputDto authInfo)
    {
        return userservice.userSignOut(authInfo);

    }
    @GetMapping("/searchRecipes/ingredients")
    public List<Recipe> searchRecipesByIngredients( @RequestParam List<String> ingredients) {
        return recipeservice.searchRecipesByIngredients(ingredients);
    }
    @GetMapping("/searchRecipesByName")
    public List<Recipe> searchRecipesByName(@RequestParam String name) {
        return recipeservice.searchRecipesByName(name);
    }

}
