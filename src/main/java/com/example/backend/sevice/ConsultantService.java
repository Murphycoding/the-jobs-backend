package com.example.backend.sevice;

import com.example.backend.models.Consultant;

import java.util.List;
import java.util.Optional;

public interface ConsultantService {

    Consultant save(Consultant consultant);
    List<Consultant> findAll();
    Optional<Consultant> findById(Long id);
}
