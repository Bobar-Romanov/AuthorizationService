package com.Main.AuthorizationService.exeption;

public class UserNotFoundException extends RuntimeException{
    public  UserNotFoundException(String message) {
        super(message);
    }
}



