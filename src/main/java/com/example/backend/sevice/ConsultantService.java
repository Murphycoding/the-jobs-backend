package com.example.backend.sevice;

import com.example.backend.models.Appointment;
import com.example.backend.models.Consultant;
import com.example.backend.models.JobSeeker;
import com.example.backend.models.User;
import com.example.backend.payload.request.ConsultantRequest;

import java.util.List;
import java.util.Optional;

public interface ConsultantService {

    Consultant save(Consultant consultant);
    List<Consultant> findAll();
    Optional<Consultant> findById(Long id);
    Consultant update(Consultant existingConsultant, ConsultantRequest consultantRequest);
    void delete(Long id);
    Optional<Consultant> findByUser(Optional<User> user);
}
