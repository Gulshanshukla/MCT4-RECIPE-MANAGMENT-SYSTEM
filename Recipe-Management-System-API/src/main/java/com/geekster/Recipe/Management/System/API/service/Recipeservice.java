package com.geekster.Recipe.Management.System.API.service;

import com.geekster.Recipe.Management.System.API.model.Recipe;
import com.geekster.Recipe.Management.System.API.model.User;
import com.geekster.Recipe.Management.System.API.model.dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.System.API.repo.IReciperepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Recipeservice {
    @Autowired
    IReciperepo iReciperepo;
    @Autowired
    UTokenservice uTokenservice;
    @Autowired
    Userservice userservice;



    public List<Recipe> AddRecipe(List<Recipe> recipes) {
        return iReciperepo.saveAll(recipes);
    }

    public List<Recipe> getAllRecipes(AuthenticationInputDto authInfo) {
        if(uTokenservice.authenticate(authInfo)) {
            return iReciperepo.findAll();
        }
        else {
            return null;
        }

    }


    public String addRecipes(Recipe newrecipes) {
       Long recipeId= newrecipes.getRecipeID();
       if(recipeId!=null &&  iReciperepo.existsById(recipeId))
       {
           return "Recipe Already Exists";

       }
       iReciperepo.save(newrecipes);
       return "Recipe Added!!!!";

    }


    public Recipe getRecipeById(Long id) {
        return iReciperepo.findById(id).orElseThrow();
    }



   // public void deleteRecipeByID(Long id) {
    //    iReciperepo.deleteById(id);


//}


    public String updateRecipe(Recipe updatedRecipe) {
        Long recipeId = updatedRecipe.getRecipeID();
        if (recipeId == null || !iReciperepo.existsById(recipeId)) {
            return "Recipe does not exist, cannot update";
        }
        // You can update the recipe details here
      iReciperepo.save(updatedRecipe);
        return "Recipe Updated!!!";
    }

    public List<Recipe> getAllRecipesByAdmin() {
        return iReciperepo.findAll();
    }

    public String deleteRecipeByID(Long id) {
        iReciperepo.deleteById(id);
        return "recipe deleted!!!";
    }

    public List<Recipe> searchRecipesByIngredients(List<String> ingredients) {
        return iReciperepo.findByRecipeIngredientsIn(ingredients);
    }

    public List<Recipe> searchRecipesByName(String name) {
        return iReciperepo.findByRecipeNameContainingIgnoreCase(name);
    }
}
