package com.Main.AuthorizationService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    @NotBlank
    @Size(max = 255)
    private String login;

    @Column(name = "password")
    @NotBlank
    @Size(max = 255)
    private String password;

    @Column(name = "role")
    @Size(max = 255)
    private String role;

}
