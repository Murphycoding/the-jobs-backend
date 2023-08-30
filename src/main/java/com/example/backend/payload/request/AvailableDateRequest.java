package com.example.backend.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class AvailableDateRequest {
    @NotBlank
    private String date;
    @NotBlank
    private String start_time;
    @NotBlank
    private String end_time;
}
