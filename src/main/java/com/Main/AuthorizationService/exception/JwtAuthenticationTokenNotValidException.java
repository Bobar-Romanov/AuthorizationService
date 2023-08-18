package com.Main.AuthorizationService.exception;

public class JwtAuthenticationTokenNotValidException extends RuntimeException{
    public JwtAuthenticationTokenNotValidException(String message) {
        super(message);
    }
}
