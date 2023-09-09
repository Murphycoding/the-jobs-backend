package com.example.backend.repository;

import com.example.backend.models.AvailableDate;
import com.example.backend.models.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    List<AvailableDate> findByConsultantId(Long consultant_id);
}
