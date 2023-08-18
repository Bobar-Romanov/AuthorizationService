package com.Main.AuthorizationService.controller;

import com.Main.AuthorizationService.dto.UserAuthenticationDTO;
import com.Main.AuthorizationService.dto.UserResponseDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;
import com.Main.AuthorizationService.service.JwtService;
import com.Main.AuthorizationService.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public UserResponseDTO registerUser(@Valid @RequestBody UserRegistrationDTO dto) {
        log.info("Try to register user: {}", dto.getLogin());
        return userService.registerUser(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public UserResponseDTO authUser(@Valid @RequestBody UserAuthenticationDTO dto) {
        log.info("Try to login: {}", dto.getLogin());
        return userService.authenticateUser(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/check-token")
    public List<GrantedAuthority> checkToken(@RequestParam String token, @RequestParam String login) {
        log.info("Try to check: {}", login);
        return  userService.getUserAuthorities(token, login);
    }
}
