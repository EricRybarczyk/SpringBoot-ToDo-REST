package dev.ericrybarczyk.todorest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderUtil {

    // run this to generate the encrypted password value to store in TodoHardcodedService (until full application is implemented)

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("your-password-here"));
    }
}
