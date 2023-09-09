package com.example.backend.sevice;

import com.example.backend.models.AvailableDate;
import com.example.backend.models.Consultant;

import java.util.List;

public interface AvailableDateService {
    void deleteAll(List<AvailableDate> list);

    List<AvailableDate> findByConsultantId(Long id);
}
