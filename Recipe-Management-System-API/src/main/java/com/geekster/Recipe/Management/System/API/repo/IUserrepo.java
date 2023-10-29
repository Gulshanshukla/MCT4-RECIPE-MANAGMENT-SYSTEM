package com.geekster.Recipe.Management.System.API.repo;

import com.geekster.Recipe.Management.System.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IUserrepo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String newEmail);
}
