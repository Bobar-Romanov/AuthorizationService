package com.Main.AuthorizationService.service;

import com.Main.AuthorizationService.dto.UserDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;

public interface UserService {
    UserDTO registerUser(UserRegistrationDTO dto);
}
