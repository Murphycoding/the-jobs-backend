package com.example.backend.controllers;
import com.example.backend.controllers.ConsultantController;
import com.example.backend.models.Consultant;
import com.example.backend.sevice.ConsultantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultantControllerTest {

    private ConsultantController consultantController;
    private ConsultantService consultantService;

    @BeforeEach
    public void setUp() {
        consultantService = new ConsultantService() {
            @Override
            public Consultant save(Consultant consultant) {
                return null;
            }

            @Override
            public List<Consultant> findAll() {
                return null;
            }

            @Override
            public Optional<Consultant> findById(Long id) {
                return Optional.empty();
            }
        }; // Create an instance of your actual service
        consultantController = new ConsultantController();
    }

    @Test
    public void testDashboardEndpoint() {
        ResponseEntity<Object> result = (ResponseEntity<Object>) consultantController.dashboard(null);
        // You need to assert the result based on the actual behavior of your controller.
        // For example, check if the status code and response body match your expectations.
        assertEquals(200, result.getStatusCodeValue());
        // Add more assertions as needed
    }

    @Test
    public void testAllEndpoint() {
        Consultant consultant1 = new Consultant(); // Create a sample consultant
        Consultant consultant2 = new Consultant(); // Create another sample consultant
        List<Consultant> consultants = Arrays.asList(consultant1, consultant2);

        // Assuming your ConsultantService returns a list of consultants without any mocking
        List<Consultant> result = consultantController.all(null);

        assertEquals(consultants.size(), result.size());
        // Add more assertions as needed
    }

    @Test
    public void testProfileEndpoint() {
        Consultant consultant = new Consultant(); // Create a sample consultant
        long consultantId = 1L;

        // Assuming your ConsultantService returns an optional consultant without any mocking
        Optional<Consultant> result = consultantController.profile(1);

        // Check if the result contains the expected consultant or is empty based on your service implementation.
        assertEquals(consultant, result.orElse(null));
        // Add more assertions as needed
    }
}
