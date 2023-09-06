package com.example.backend.sevice;

import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;

import java.util.Optional;

public interface JobSeekerService {
    JobSeeker save(JobSeeker jobSeeker);
    Optional<JobSeeker> findByUser(User user);
}
