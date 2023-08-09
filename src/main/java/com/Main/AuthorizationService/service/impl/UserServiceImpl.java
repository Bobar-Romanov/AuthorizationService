package com.Main.AuthorizationService.service.impl;

import com.Main.AuthorizationService.dto.UserDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;
import com.Main.AuthorizationService.model.User;
import com.Main.AuthorizationService.repository.UserRepository;
import com.Main.AuthorizationService.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final CustomUserDetailsService userDetailsService;
    private ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(CustomUserDetailsService userDetailsService, UserRepository userRepository, ModelMapper modelMapper) {
        this.userDetailsService = userDetailsService;
        this.userRepository =  userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO registerUser(@Valid UserRegistrationDTO dto) {
        if (userRepository.existsByLogin(dto.getLogin())) {
            log.info("User not found: ", dto.getLogin());
            throw new UsernameNotFoundException("User not found: " + dto.getLogin());
        }
        User user = modelMapper.map(dto, User.class);
        userRepository.save(user);
        log.info("User saved: {}", user.getLogin());
        return modelMapper.map(user, UserDTO.class);
    }
}
