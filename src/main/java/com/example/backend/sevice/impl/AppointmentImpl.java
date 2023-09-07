package com.example.backend.sevice.impl;

import com.example.backend.models.Appointment;
import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;
import com.example.backend.repository.AppointmentRepository;
import com.example.backend.sevice.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment save(Consultant consultant, JobSeeker jobSeeker) {
        Appointment appointment = new Appointment(
            "PENDING",
            null,
            consultant,
            jobSeeker
        );

        return appointmentRepository.save(appointment);

    }
}
