package com.geekster.Recipe.Management.System.API.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationInputDto {
    private String email;
    private String tokenValue;
}
