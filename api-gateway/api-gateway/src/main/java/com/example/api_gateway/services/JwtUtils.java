package com.example.api_gateway.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtils {
    private final String secretKey = "errggt3tl3t3j0gij94j5g9d8AVA76vb87v67v8bV6B9GBR98G9G304GNj0rgj409g4gh349gj309gj4trtpomrtmhrtergegrhtr";

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isExpired(String token) {
        try {
            return getClaims(token).getExpiration().before(new Date());
        } catch(Exception e){
            return false;
        }
    }

    public Integer extractUserId(String token){
        try {
            return Integer.parseInt(getClaims(token).getSubject());
        }catch(NullPointerException e){
            return null;
        }
    }
}
