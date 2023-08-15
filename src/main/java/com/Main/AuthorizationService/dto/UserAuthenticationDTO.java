package com.Main.AuthorizationService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthenticationDTO {
    @NotBlank
    @Size(max = 255)
    private String login;
    @NotBlank
    @Size(max = 255)
    private String password;
}
