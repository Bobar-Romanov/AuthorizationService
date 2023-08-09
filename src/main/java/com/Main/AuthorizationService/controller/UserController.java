package com.Main.AuthorizationService.controller;

import com.Main.AuthorizationService.dto.UserDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;
import com.Main.AuthorizationService.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/registration")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody UserRegistrationDTO dto) {
        log.info("Try to register user: {}", dto.getLogin());
        return userService.registerUser(dto);
    }

}
