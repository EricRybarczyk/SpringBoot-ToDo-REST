package dev.ericrybarczyk.todorest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {

    @GetMapping("/basic-auth")
    public AuthenticationBean checkUserAuthentication() {
        // this is basically a placeholder (but successful) response for now
        return new AuthenticationBean("You are authenticated");
    }
}
