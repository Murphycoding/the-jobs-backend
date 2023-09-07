package com.example.backend.repository;

import com.example.backend.models.Appointment;
import com.example.backend.models.AvailableDate;
import com.example.backend.models.Consultant;
import com.example.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    List<Appointment> listFindByUser(User user);
}
