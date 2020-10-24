package dev.ericrybarczyk.todorest.jwt.controller;

// Source: https://github.com/in28minutes/full-stack-with-angular-and-spring-boot

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

    private final static long serialVersionUID = 1L;

    private final String token;

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
