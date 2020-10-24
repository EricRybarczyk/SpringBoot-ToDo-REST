package dev.ericrybarczyk.todorest.jwt;

// Source: https://github.com/in28minutes/full-stack-with-angular-and-spring-boot

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes", "$2a$10$677qmJBce.7AjC4HKZGwk.NmpgMu2kThG/vCTbyWlFLgAjYE0cTDi", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(1L, "demouser", "$2a$10$6C5gkCX2E8uKNsd9bDZfju.hxwgm3doPWf2CazMRbvXIbjTQ0xoru", "ROLE_USER_2"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }

}
