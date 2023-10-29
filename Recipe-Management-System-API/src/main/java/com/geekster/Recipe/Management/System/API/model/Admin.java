package com.geekster.Recipe.Management.System.API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Admin {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long adminId;

    private String adminName;
    @Pattern(regexp = ".*:\\@recipe\\.owner\\.in$")

    private String adminEmail;
    private String adminPassword;



}
