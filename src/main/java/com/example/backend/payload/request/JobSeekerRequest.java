package com.example.backend.payload.request;

import jakarta.validation.constraints.NotBlank;

import java.lang.String;

public class JobSeekerRequest {
    @NotBlank
    private String tp;
    @NotBlank
    private String address;
    @NotBlank
    private String dob;
    @NotBlank
    private String nic;
    @NotBlank
    private String gender;

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
}
