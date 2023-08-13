package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "available_date")
public class AvailableDate {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank
        private Date start_at;
        @NotBlank
        private Date end_at;
        @OneToOne
        @JoinColumn(name = "consultant_id")
        private Consultant consultant;
}
