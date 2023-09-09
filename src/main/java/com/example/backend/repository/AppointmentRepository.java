package com.example.backend.repository;

import com.example.backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByJobSeeker(JobSeeker jobSeeker);
    List<Appointment> findByConsultant(Consultant consultant);
}
