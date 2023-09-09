package com.example.backend.sevice;

import com.example.backend.models.Appointment;
import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment save(Consultant consultant, JobSeeker jobSeeker);
    Optional<Appointment> findById(Long id);
    List<Appointment> findByJobSeeker(JobSeeker jobSeeker);
    List<Appointment> findByConsultant(Consultant consultant);
    Appointment accepted(Appointment appointment);
}
