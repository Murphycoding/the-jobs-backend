package com.example.backend.controllers;

import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;
import com.example.backend.payload.request.ConsultantRequest;
import com.example.backend.payload.request.IdRequest;
import com.example.backend.security.services.UserDetailsServiceImpl;
import com.example.backend.sevice.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping("/save")
    @PreAuthorize("hasRole('jOB_SEEKER')")
    public Object save(HttpServletRequest request, @RequestBody IdRequest idRequest) {

        String token = jwtService.getJwtFromCookies(request);
        String username = jwtService.getUserNameFromJwtToken(token);
        Optional<User> user = userService.findUserByUsername(username);
        Optional<JobSeeker> job_seeker = jobSeekerService.findByUser(user);
        Optional<Consultant> consultant = consultantService.findById(Long.valueOf(idRequest.getId()));

        return appointmentService.save(consultant.orElse(new Consultant()),job_seeker.orElse(new JobSeeker()));
    }
}
