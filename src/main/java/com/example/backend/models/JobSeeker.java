package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "job_seekers",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "tp"),
                @UniqueConstraint(columnNames = "nic")
        })
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 15)
    private String tp;
    @NotBlank
    @Size(max = 255)
    private String address;
    @NotBlank
    private Date dob;
    @NotBlank
    @Size(max = 12)
    private String  nic;
    @NotBlank
    @Size(max = 10)
    private String  gender;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

}
