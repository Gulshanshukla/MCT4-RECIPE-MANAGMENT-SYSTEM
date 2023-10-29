package com.geekster.Recipe.Management.System.API.service;

import com.geekster.Recipe.Management.System.API.model.User;
import com.geekster.Recipe.Management.System.API.model.UserAuthenticationToken;
import com.geekster.Recipe.Management.System.API.model.dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.System.API.model.dto.SignInInputDto;
import com.geekster.Recipe.Management.System.API.repo.IUserrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service

public class Userservice {
    @Autowired
    IUserrepo iUserrepo;
    @Autowired
    UTokenservice uTokenservice;

    public String userSignUp(User user) {
        //check email if already exists---> not allowed,try logging in
        String newEmail= user.getUserEmail();
        User existingUser=iUserrepo.findFirstByUserEmail(newEmail);
        if(existingUser!=null)
        {
            return "Email Already In Use";
        }

        //passwords are encrypted before storing it in table or database
        String signUpPassword= user.getUserPassword();
        try {
            String encryptedPassword=PasswordEncrypter.encrypt(signUpPassword);
            user.setUserPassword(encryptedPassword);
            iUserrepo.save(user);
            return "User Registered";

        } catch (NoSuchAlgorithmException e) {
          return "Internal Server Issues While Saving Password,Try Again Later!!!!!";
        }


        //if valid email //user table ---->save user


    }

    public String userSignIn(SignInInputDto signInInputDto) {
        //check if the email already in the database

        //signin  is only possible if the person ever signed up or registered in past
        //password should be matched
        String email= signInInputDto.getEmail();
        User existingUser= iUserrepo.findFirstByUserEmail(email);
        if(existingUser==null)
        {
            return "Not A Valid Email,Please Signup First";//invalid credentials
        }
        //password should be matched
        String password= signInInputDto.getPassword();
        try {
            String encryptedPassword=PasswordEncrypter.encrypt(password);
            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                //return a token for the signin
                UserAuthenticationToken token= new UserAuthenticationToken(existingUser);
                uTokenservice.createToken(token);
                return token.getTokenValue();

            }
            else {
                return "Invalid Credential";
            }


        } catch (NoSuchAlgorithmException e) {
            return "Internal Server Issues While Saving Password,Try Again Later!!!!!";
        }

        //if signin is done give a token to user or session ticket to the user means access token is
        //granted to user.

    }

    public String userSignOut(AuthenticationInputDto authInfo) {
        if(uTokenservice.authenticate(authInfo)) {
            String tokenValue = authInfo.getTokenValue();
            uTokenservice.deleteToken(tokenValue);
            return "Sign Out Successful";
        }
        else {
            return "Un Authenticated Access!!!";
        }


    }

    public List<User> getAllUsers() {
        return iUserrepo.findAll();
    }
}
