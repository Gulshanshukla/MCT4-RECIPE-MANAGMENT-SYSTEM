package com.geekster.Recipe.Management.System.API.service;

import com.geekster.Recipe.Management.System.API.model.UserAuthenticationToken;
import com.geekster.Recipe.Management.System.API.model.dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.System.API.repo.IUTokenrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UTokenservice {
    @Autowired
    IUTokenrepo iuTokenrepo;

    public void createToken(UserAuthenticationToken token) {
        iuTokenrepo.save(token);
    }

    public void deleteToken(String tokenValue) {
       UserAuthenticationToken token= iuTokenrepo.findFirstByTokenValue(tokenValue);
       iuTokenrepo.delete(token);
    }

    public boolean authenticate(AuthenticationInputDto authInfo) {
        String email= authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();
        ///find the actual token and then get the connected user getits email and verify with passed email
     //  return  iuTokenrepo.findFirstByTokenValue(tokenValue).getUser().getUserEmail().equals(email);
        UserAuthenticationToken token=iuTokenrepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else {
            return false;
        }

    }
}
