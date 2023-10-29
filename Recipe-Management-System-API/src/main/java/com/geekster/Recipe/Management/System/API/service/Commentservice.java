package com.geekster.Recipe.Management.System.API.service;

import com.geekster.Recipe.Management.System.API.model.Comment;
import com.geekster.Recipe.Management.System.API.repo.ICommentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Commentservice {
    @Autowired
    ICommentrepo iCommentrepo;

    public Comment AddComment(Comment comment) {
        return iCommentrepo.save(comment);
    }

    public List<Comment> getAllComments() {
        return iCommentrepo.findAll();
    }


    public boolean deleteComment(Long commentId) {
        Comment comment= iCommentrepo.findById(commentId).orElse(null);
        if(comment!=null)
        {
            iCommentrepo.delete(comment);
            return true;
        }
        else {
            return false;
        }
    }

}
