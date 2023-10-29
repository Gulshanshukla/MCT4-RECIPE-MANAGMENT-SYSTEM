package com.geekster.Recipe.Management.System.API.controller;

import com.geekster.Recipe.Management.System.API.model.Comment;
import com.geekster.Recipe.Management.System.API.service.Commentservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated

public class Commentcontroller {
    @Autowired
    Commentservice commentservice;
    @PostMapping("comment")

        public Comment AddComment(@Valid @RequestBody Comment comment) {
        return commentservice.AddComment(comment);

        }
        @GetMapping("comments")
       public List<Comment> getAllComments()
        {
            return commentservice.getAllComments();
        }
        @DeleteMapping("comment/delete/id/{id}")
    public String deleteComment(@Valid @PathVariable  Long commentId)
        {
            if(commentservice.deleteComment(commentId))
            {
                return "Comment Deleted Successfully";
            }
            else {
                return "Comment Not Found Or You Don't Have Permission To Delete It";
            }
        }

}
