package com.example.backend.sevice.impl;

import com.example.backend.models.Consultant;
import com.example.backend.models.User;
import com.example.backend.payload.request.ConsultantRequest;
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
    @Override
    public Consultant update(Consultant existingConsultant, ConsultantRequest consultantRequest) {
        // Update the existing Consultant entity with the data from consultantRequest
        existingConsultant.setAddress(consultantRequest.getAddress());
        existingConsultant.setDob(consultantRequest.getDob());
        existingConsultant.setGender(consultantRequest.getGender());
        existingConsultant.setContact_number(consultantRequest.getContact_number());
        existingConsultant.setNic(consultantRequest.getNic());
        existingConsultant.setFirst_name(consultantRequest.getFirst_name());
        existingConsultant.setLast_name(consultantRequest.getLast_name());
        existingConsultant.setSpecialized_area(consultantRequest.getSpecialized_area());
        existingConsultant.setSpecialized_country(consultantRequest.getSpecialized_country());
        // Update other properties as needed

        // Save the updated Consultant in the repository
        return consultantRepository.save(existingConsultant);
    }
    @Override
    public void delete(Long id){
         consultantRepository.deleteById(id);
    }
    @Override
    public Optional<Consultant> findByUser(Optional<User> user){
        return consultantRepository.findByUser(user.orElse(new User()));
    }
}
