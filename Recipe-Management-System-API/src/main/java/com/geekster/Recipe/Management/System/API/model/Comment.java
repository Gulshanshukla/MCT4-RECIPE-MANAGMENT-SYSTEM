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

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Lob
    @NotEmpty
    private String commentContent;
    @ManyToOne
    @JoinColumn(name="fk_user_Id")
    private User user;
    @ManyToOne
    @JoinColumn(name="fk_recipe_id")
    private Recipe recipe;

}
