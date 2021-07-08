package com.github.ratel.security;

import com.github.ratel.exceptions.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Log
@Component
public class JwtTokenProvider {

    @Value("${app.jwt.secret}")
    private String secretWord;

    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256, this.secretWord)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secretWord).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new InvalidTokenException("Invalid token");
        }
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secretWord).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secretWord.getBytes()).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

}
