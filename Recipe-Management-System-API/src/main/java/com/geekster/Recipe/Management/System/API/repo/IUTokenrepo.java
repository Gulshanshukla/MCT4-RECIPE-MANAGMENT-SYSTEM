package com.geekster.Recipe.Management.System.API.repo;

import com.geekster.Recipe.Management.System.API.model.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IUTokenrepo extends JpaRepository<UserAuthenticationToken,Long> {


    UserAuthenticationToken findFirstByTokenValue(String tokenValue);
}
