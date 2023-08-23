package com.example.backend.controllers;

import com.example.backend.models.JobType;
import com.example.backend.models.Role;
import com.example.backend.repository.JobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/job-type")
public class JobTypeController {
    @Autowired
    JobTypeRepository jobTypeRepository;
    @GetMapping("/all")
    @PreAuthorize("hasRole('jOB_SEEKER') or hasRole('CONSULTANT') or hasRole('ADMIN')")
    public List<JobType> all() {
        return jobTypeRepository.findAll();
    }
}
