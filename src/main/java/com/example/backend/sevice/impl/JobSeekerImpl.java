package com.example.backend.sevice.impl;

import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;
import com.example.backend.repository.JobSeekerRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.sevice.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerImpl implements JobSeekerService {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Override
    public JobSeeker save(JobSeeker jobSeeker){
        return  jobSeekerRepository.save(jobSeeker);
    }
    @Override
    public Optional<JobSeeker> findByUser(User user){
        return  jobSeekerRepository.findByUser(user);
    }
}
