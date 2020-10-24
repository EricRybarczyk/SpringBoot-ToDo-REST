package auth.removed.basic;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and() // https://stackoverflow.com/a/37610988/798642 and https://docs.spring.io/spring-security/site/docs/5.4.1/reference/html5/#cors
                .csrf().disable() // we will be using JWT tokens, not CSRF tokens
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // allow all OPTIONS requests including unauthenticated
                .anyRequest().authenticated() // all other requests must be authenticated
                .and().httpBasic(); // currently only HTTP Basic auth
    }

}
