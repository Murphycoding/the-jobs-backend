package com.example.backend.controllers;

import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;
import com.example.backend.payload.request.JobSeekerRequest;
import com.example.backend.repository.JobSeekerRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.services.UserDetailsImpl;
import com.example.backend.security.services.UserDetailsServiceImpl;
import com.example.backend.sevice.JobSeekerService;
import com.example.backend.sevice.JwtService;
import com.example.backend.sevice.UserService;
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
    private JwtService jwtService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserService userService;

    @Autowired
    JobSeekerService jobSeekerService;
    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('jOB_SEEKER')")
    public Object dashboard(HttpServletRequest request) {
        String token = jwtService.getJwtFromCookies(request);
        String username = jwtService.getUserNameFromJwtToken(token);
        Optional<User> user = userService.findByUsername(username);
        Optional<JobSeeker> jobSeeker = jobSeekerService.findByUser(user.orElse(new User()));
        return jobSeeker;
    }
    @PostMapping("/save")
    @PreAuthorize("hasRole('jOB_SEEKER')")
    public Object save(HttpServletRequest request , @RequestBody JobSeekerRequest jobSeekerRequest){
        String token = jwtService.getJwtFromCookies(request);
        String username = jwtService.getUserNameFromJwtToken(token);
        Optional<User> user = userService.findByUsername(username);

        JobSeeker jobSeeker = new JobSeeker(
                jobSeekerRequest.getFirst_name(),
                jobSeekerRequest.getLast_name(),
                jobSeekerRequest.getContact_number(),
                jobSeekerRequest.getAddress(),
                jobSeekerRequest.getDob(),
                jobSeekerRequest.getNic(),
                jobSeekerRequest.getGender(),
                jobSeekerRequest.getJob_type(),
                user.orElse(new User())
        );
//        return "work";

        return jobSeekerService.save(jobSeeker);
    }
}
