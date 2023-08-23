package com.Main.AuthorizationService.service;

import com.Main.AuthorizationService.dto.UserAuthenticationDTO;
import com.Main.AuthorizationService.dto.UserResponseDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface UserService {
    UserResponseDTO registerUser(UserRegistrationDTO dto);
    UserResponseDTO authenticateUser(UserAuthenticationDTO dto);
    List<GrantedAuthority> getUserAuthorities(String token);
}
