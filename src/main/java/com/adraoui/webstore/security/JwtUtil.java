
package com.adraoui.webstore.security;
import com.adraoui.webstore.config.JwtProperties;
import loombok.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;



@Component
@AllArgsConstructor
@NoArgsConstructor
 
public class JwtUtil {
    private JwtProperties jwtProperties;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(jwtProperties.getSecretBytes());
    }

     public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
     

    public String generateToken(CustomUserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // System.out.println("am failing here1");
        claims.put("role", userDetails.getAuthorities().iterator().next().getAuthority());
        // System.out.println("am failing here2");

        long expiration = 100000 * 60 * 60; 
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


      public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

     public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

     public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    public String extractRole(String token){
        return extractAllClaims(token).get("role", String.class);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}