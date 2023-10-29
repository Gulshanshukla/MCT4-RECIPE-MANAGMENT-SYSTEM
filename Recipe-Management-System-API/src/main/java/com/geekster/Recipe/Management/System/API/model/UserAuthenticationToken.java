package com.geekster.Recipe.Management.System.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="UserAuthentication")


public class UserAuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationTime;
    @OneToOne
    @JoinColumn(name="fk_user_Id")
    User user;

    public UserAuthenticationToken(User user) {
        this.user=user;
        this.tokenCreationTime=LocalDateTime.now();
        //uses the time of system to generate uuid
        this.tokenValue= UUID.randomUUID().toString();

    }
}
