package com.geekster.Recipe.Management.System.API.repo;

import com.geekster.Recipe.Management.System.API.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ICommentrepo extends JpaRepository<Comment,Long> {
}
