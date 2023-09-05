package com.example.backend.controllers;
import com.example.backend.payload.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // Clear any existing security context
        SecurityContextHolder.clearContext();
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        // Define your LoginRequest object here
        LoginRequest loginRequest = new LoginRequest("sajiyabro","123456");
        System.out.println(asJsonString(loginRequest));
        // Simulate an authentication object
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        // Set the authentication object in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Perform the POST request with your LoginRequest
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(loginRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.header().exists("Set-Cookie"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("sajiyabro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("sajiyabro@gmail.com"));
        // Add more assertions as needed
    }
    @Test
    public void testRegisterUserSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signup")
                        .content("{\"username\": \"testuser\", \"email\": \"test@example.com\", \"password\": \"password\", \"role\": [\"job_seeker\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"User registered successfully!\"}"));
    }
    // Utility method to convert an object to JSON string
    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}