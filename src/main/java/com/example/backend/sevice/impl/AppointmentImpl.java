package com.example.backend.sevice.impl;

import com.example.backend.models.Appointment;
import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;
import com.example.backend.repository.AppointmentRepository;
import com.example.backend.sevice.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findByJobSeeker(JobSeeker jobSeeker) {

       return appointmentRepository.findByJobSeeker(jobSeeker);
    }

    @Override
    public List<Appointment> findByConsultant(Consultant consultant) {
        return appointmentRepository.findByConsultant(consultant);
    }

    public Appointment accepted(Appointment appointment) {
        appointment.setAccepted_at(new Date());
        appointment.setStatus("ACCEPTED");
        return appointmentRepository.save(appointment);
    }

}
