package com.example.backend.controllers;

import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;
import com.example.backend.payload.request.ConsultantRequest;
import com.example.backend.payload.request.JobSeekerRequest;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.jwt.JwtUtils;
import com.example.backend.security.services.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/consultant")
public class ConsultantController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    ConsultantRepository consultantRepository;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('CONSULTANT')")
    public Object dashboard(HttpServletRequest request) {

        return null;
    }
    @PostMapping("/save")
    @PreAuthorize("hasRole('CONSULTANT')")
    public Object save(HttpServletRequest request , @RequestBody ConsultantRequest consultantRequest){

        String token = jwtUtils.getJwtFromCookies(request);
        String username = jwtUtils.getUserNameFromJwtToken(token);
        Optional<User> user = userRepository.findByUsername(username);

        Consultant consultant = new Consultant(
                consultantRequest.getSpecialized_area(),
                consultantRequest.getSpecialized_country(),
                consultantRequest.getTp(),
                consultantRequest.getAddress(),
                consultantRequest.getDob(),
                consultantRequest.getNic(),
                consultantRequest.getGender(),
                user.orElse(new User())
        );
        return consultantRepository.save(consultant);
    }

}
