package dev.ericrybarczyk.todorest.jwt.controller;

// Source: https://github.com/in28minutes/full-stack-with-angular-and-spring-boot

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
