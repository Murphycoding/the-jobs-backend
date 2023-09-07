package com.example.backend.controllers;

import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;
import com.example.backend.payload.request.LoginRequest;
import com.example.backend.payload.response.UserInfoResponse;
import com.example.backend.repository.JobSeekerRepository;
import com.example.backend.repository.RoleRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.services.UserDetailsImpl;
import com.example.backend.security.services.UserDetailsServiceImpl;
import com.example.backend.sevice.ConsultantService;
import com.example.backend.sevice.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    ConsultantService consultantService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public Object dashboard(HttpServletRequest request) {
        return null;
    }
}
