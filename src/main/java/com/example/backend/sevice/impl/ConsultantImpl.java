package com.example.backend.sevice.impl;

import com.example.backend.models.Consultant;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.sevice.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultantImpl implements ConsultantService {
    @Autowired
    private ConsultantRepository consultantRepository;
    @Override
    public Consultant save(Consultant consultant){
        return consultantRepository.save(consultant);
    }
    @Override
    public Optional<Consultant> findById(Long id){
        return consultantRepository.findById(id);
    }
    @Override
    public List<Consultant> findAll(){
        return consultantRepository.findAll();
    }
}
