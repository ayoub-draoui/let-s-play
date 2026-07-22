package com.adraoui.webstore.security;

import com.adraoui.webstore.service.UserDetailsService;
import lombook.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.adraoui.webstore.service.customUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@Component
@AllArgsConstructor

public class JwtFilter extends OncePerRequestFilter {
    private JwtUtil jwtUtil;

    private customUserDetailsService customUserDetailsService;

    @Override 
        protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterchain) throws ServerException{
                final String authHeader = request.getHeader("Authorization");
                String username = null;
                String token = null;
                try {
                    if (authHeader != null && authHeader.startsWith("Bearer ")){
                        token = authHeader.substring(7);
                        username = jwtUtil.extractUsername(token);

                    }
                    if (username != null && 
                        SecurityContextHolder.getContext().getAuthontication() == null) {
                       UserDetailsService userDetailsService = userDetailsService.loadUserByUserName();    
                       
                       if (jwtUtil.validateToken(token, userDetailsService.getUsername)){
                        UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(
                            userDetailsService, null,
                            userDetailsService.getAuthorities());
                        authtoken.setDetails(
                            new WebAuthenticationDetailsSource()
                            .buildDetails(request));
                        SecurityContextHolder.getContext().setAuthontication(authtoken); 
                       }
                    }
                    } catch (Exception e){
                        System.out.println("JWT Filter Error: " + e.getMessage());
                         e.printStackTrace();
            } 
            filterchain.doFilter(request, response);
        }       
}