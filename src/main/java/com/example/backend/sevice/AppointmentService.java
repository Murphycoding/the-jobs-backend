package com.example.backend.sevice;

import com.example.backend.models.Appointment;
import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;

public interface AppointmentService {
    Appointment save(Consultant consultant, JobSeeker jobSeeker);
}
