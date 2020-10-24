package dev.ericrybarczyk.todorest.jwt;

// Source: https://github.com/in28minutes/full-stack-with-angular-and-spring-boot

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtUnAuthorizedResponseAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private final static long serialVersionUID = 1L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You would need to provide the Jwt Token to Access This resource");
    }
}
