package com.Main.AuthorizationService.service;

import com.Main.AuthorizationService.dto.UserAuthenticationDTO;
import com.Main.AuthorizationService.dto.UserResponseDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;

public interface UserService {
    UserResponseDTO registerUser(UserRegistrationDTO dto);

    UserResponseDTO authenticateUser(UserAuthenticationDTO dto);
}
