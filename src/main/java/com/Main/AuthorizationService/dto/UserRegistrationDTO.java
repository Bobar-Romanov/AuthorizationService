package com.Main.AuthorizationService.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationDTO {

    @NotBlank
    @Size(max = 255)
    private String login;

    @NotBlank
    @Size(max = 255)
    private String password;

    @Size(max = 255)
    private String role;

    public UserRegistrationDTO(Long id, String login, String password) {
        this.login = login;
        this.password = password;
        this.role = "USER";
    }
}
