package com.example.backend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/job-seeker")
public class JobSeekerController {
    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('jOB_SEEKER')")
    public Object dashboard(HttpServletRequest request) {

        return null;
    }
}
