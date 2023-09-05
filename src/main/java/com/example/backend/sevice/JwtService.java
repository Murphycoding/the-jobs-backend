package com.example.backend.sevice;

import com.example.backend.security.services.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;

public interface JwtService {
    String getJwtFromCookies(HttpServletRequest request);

    ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal);

    ResponseCookie getCleanJwtCookie();

    String getUserNameFromJwtToken(String token);

    boolean validateJwtToken(String authToken);
}
