package com.Main.AuthorizationService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestController {

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public String testUser() {
        return "OK, u a user";
    }

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public String testAdmin() {
        return "OK, u a admin";
    }

}
