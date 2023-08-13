package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "consultants",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "tp"),
                @UniqueConstraint(columnNames = "nic")
        })
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 255)
    private String specialized_area;
    @NotBlank
    @Size(max = 255)
    private String specialized_country;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialized_area() {
        return specialized_area;
    }

    public void setSpecialized_area(String specialized_area) {
        this.specialized_area = specialized_area;
    }

    public String getSpecialized_country() {
        return specialized_country;
    }

    public void setSpecialized_country(String specialized_country) {
        this.specialized_country = specialized_country;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public Consultant() {
    }

    public Consultant(Long id, String specialized_area, String specialized_country, String tp, String address, Date dob, String nic, String gender, User user) {
        this.id = id;
        this.specialized_area = specialized_area;
        this.specialized_country = specialized_country;
        this.tp = tp;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.gender = gender;
        this.user = user;
    }
}
