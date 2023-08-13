package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 10)
    private String  status;
    @NotBlank
    private Date accepted_at;

    @OneToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;
    @OneToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
