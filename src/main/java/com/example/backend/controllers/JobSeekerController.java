package com.example.backend.controllers;

import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;
import com.example.backend.payload.request.JobSeekerRequest;
import com.example.backend.repository.JobSeekerRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.jwt.JwtUtils;
import com.example.backend.security.services.UserDetailsImpl;
import com.example.backend.security.services.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/job-seeker")
public class JobSeekerController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    JobSeekerRepository jobSeekerRepository;
    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('jOB_SEEKER')")
    public Object dashboard(HttpServletRequest request) {
        String token = jwtUtils.getJwtFromCookies(request);
        String username = jwtUtils.getUserNameFromJwtToken(token);
        Optional<User> user = userRepository.findByUsername(username);
        Optional<JobSeeker> jobSeeker = jobSeekerRepository.findByUser(user.orElse(new User()));
        return jobSeeker;
    }
    @PostMapping("/save")
    @PreAuthorize("hasRole('jOB_SEEKER')")
    public Object save(HttpServletRequest request , @RequestBody JobSeekerRequest jobSeekerRequest){

        String token = jwtUtils.getJwtFromCookies(request);
        String username = jwtUtils.getUserNameFromJwtToken(token);
        Optional<User> user = userRepository.findByUsername(username);

        JobSeeker jobSeeker = new JobSeeker(
                jobSeekerRequest.getTp(),
                jobSeekerRequest.getAddress(),
                jobSeekerRequest.getDob(),
                jobSeekerRequest.getNic(),
                jobSeekerRequest.getGender(),
                user.orElse(new User())
        );
//        return jobSeeker;
        return jobSeekerRepository.save(jobSeeker);
    }
}
