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
    private String first_name;
    @NotBlank
    private String last_name;
    @NotBlank
    private String contact_number;
    @NotBlank
    private String address;
    @NotBlank
    private String dob;
    @NotBlank
    private String nic;
    @NotBlank
    private String gender;
    @NotBlank
    private String job_type;

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
}
