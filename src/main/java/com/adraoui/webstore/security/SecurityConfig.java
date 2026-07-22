package com.adraoui.webstore.security;



import lombok.AllArgsConstructor;
import com.adraoui.webstore.service.UserDetailsService;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final customUserDetailsService UserDetailsService;
    private final JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exeption{
       http
       .csrf(csrf -> csrf.disable())
       .authorizeHttpRequests(auth -> 
                auth.requestMatchers("/auth/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
                    .requestMatchers("/users/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            );
        
    }
}