package com.Main.AuthorizationService.service.impl;

import com.Main.AuthorizationService.dto.UserAuthenticationDTO;
import com.Main.AuthorizationService.dto.UserResponseDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;
import com.Main.AuthorizationService.exeption.UserAlreadyExistsException;
import com.Main.AuthorizationService.model.User;
import com.Main.AuthorizationService.repository.UserRepository;
import com.Main.AuthorizationService.service.CustomUserDetailsService;
import com.Main.AuthorizationService.service.UserService;
import com.Main.AuthorizationService.utils.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final CustomUserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;


    @Override
    public UserResponseDTO registerUser(UserRegistrationDTO dto) {
        if (userRepository.existsByLogin(dto.getLogin())) {
            log.info("User already exist: ", dto.getLogin());
            throw new UserAlreadyExistsException("User already exist: " + dto.getLogin());
        }
        User user = userMapper.toUser(dto);
        userRepository.save(user);
        log.info("New user created: {}", user.getLogin());
        return userMapper.toUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO authenticateUser(UserAuthenticationDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getLogin(),
                        dto.getPassword()
                )
        );
        User user = userDetailsService.loadUserByUsername(dto.getLogin());

        UserResponseDTO userResponseDTO = userMapper.toUserResponseDTO(user);
        log.info("Authenticate: {}", user.getLogin());
        return userResponseDTO;
    }
}
