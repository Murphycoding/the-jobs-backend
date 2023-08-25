package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.String;
import java.util.Optional;

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
    private String dob;
    @NotBlank
    @Size(max = 12)
    private String  nic;
    @NotBlank
    @Size(max = 10)
    private String  gender;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    public JobSeeker(String tp, String address, String dob, String nic, String gender, User user) {
        this.tp = tp;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.gender = gender;
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

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
