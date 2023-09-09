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

    private Date accepted_at;

    @OneToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;
    @OneToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    public Appointment(String status, Date accepted_at, Consultant consultant, JobSeeker jobSeeker) {
        this.status = status;
        this.accepted_at = accepted_at;
        this.consultant = consultant;
        this.jobSeeker = jobSeeker;
    }

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAccepted_at() {
        return accepted_at;
    }

    public void setAccepted_at(Date accepted_at) {
        this.accepted_at = accepted_at;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}
