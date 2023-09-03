package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.String;
import java.util.Optional;

@Entity
@Table(name = "job_seekers",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "contact_number"),
                @UniqueConstraint(columnNames = "nic")
        })
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 255)
    private String first_name;
    @NotBlank
    @Size(max = 255)
    private String last_name;
    @NotBlank
    @Size(max = 15)
    private String contact_number;
    @NotBlank
    @Size(max = 255)
    private String address;
    @NotBlank
    @Size(max = 255)
    private String dob;
    @NotBlank
    @Size(max = 12)
    private String  nic;
    @NotBlank
    @Size(max = 10)
    private String  gender;
    @NotBlank
    @Size(max = 255)
    private String  job_type;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public JobSeeker(String first_name, String last_name, String contact_number, String address, String dob, String nic, String gender, String job_type, User user) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_number = contact_number;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.gender = gender;
        this.job_type = job_type;
        this.user = user;
    }

    public JobSeeker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
