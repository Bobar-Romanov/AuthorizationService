package com.Main.AuthorizationService.utils;

import com.Main.AuthorizationService.dto.UserAuthenticationDTO;
import com.Main.AuthorizationService.dto.UserResponseDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;
import com.Main.AuthorizationService.model.User;
import com.Main.AuthorizationService.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User toUser(UserRegistrationDTO userRegistrationDTO) {
        User user =  modelMapper.map(userRegistrationDTO, User.class);
        user.setRole(Role.USER);
        //user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        return user;
    }

    public UserResponseDTO toUserResponseDTO (User user) {
        UserResponseDTO userResponseDTO =  modelMapper.map(user, UserResponseDTO.class);
        userResponseDTO.setToken(jwtService.generateToken(user));
        return userResponseDTO;
    }
    public User toUser (UserAuthenticationDTO userAuthenticationDTO){
        return modelMapper.map(userAuthenticationDTO, User.class);
    }


}
