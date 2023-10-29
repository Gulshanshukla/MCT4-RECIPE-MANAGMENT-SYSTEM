package com.geekster.Recipe.Management.System.API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeID;
    @NotEmpty

    private String recipeName;
    @Lob
    @NotEmpty

    private String recipeIngredients;
    @Lob
    @NotEmpty
    private String recipeInstructions;
    @ManyToOne
    @JoinColumn(name="fk_user_id")
    private User owner;

}
