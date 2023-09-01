package com.example.backend.repository;

import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    Optional<JobSeeker> findByUser(User user);
}
