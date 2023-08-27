package com.example.backend.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.String;

public class ConsultantRequest {
    @NotBlank
    private String specialized_area;
    @NotBlank
    private String specialized_country;
    @NotBlank
    private String tp;
    @NotBlank
    private String address;
    @NotBlank
    private String dob;
    @NotBlank
    private String  nic;
    @NotBlank
    private String  gender;

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
