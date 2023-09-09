package com.example.backend.sevice.impl;

import com.example.backend.models.AvailableDate;
import com.example.backend.models.Consultant;
import com.example.backend.repository.AvailableDateRepository;
import com.example.backend.sevice.AvailableDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableDateImpl implements AvailableDateService {
    @Autowired
    private AvailableDateRepository availableDateRepository;

    @Override
    public void deleteAll(List<AvailableDate> list){

        availableDateRepository.deleteAll(list);
    }


    @Override
    public List<AvailableDate> findByConsultantId(Long id){

        return availableDateRepository.findByConsultantId(id);
    }

}
