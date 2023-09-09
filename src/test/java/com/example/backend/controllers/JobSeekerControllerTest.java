//package com.example.backend.controllers;
//import com.example.backend.payload.request.JobSeekerRequest;
//import com.example.backend.payload.request.LoginRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.http.Cookie;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class JobSeekerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    private Cookie[] cookies;
//    @BeforeEach
//    public void setUp() {
//        // Perform any setup or mocking required for your tests.
//    }
//
//    public void testLoginAndUseCookies() throws Exception {
//        LoginRequest loginRequest = new LoginRequest("sajiyabro","123456");
//        // Perform a login operation and extract cookies from the response
//        ResultActions loginResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signin")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(loginRequest)));
//
//        MvcResult loginMvcResult = loginResult.andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//
//        // Extract and store cookies from the response
//        cookies = loginMvcResult.getResponse().getCookies();
//        if (cookies == null) {
//            throw new IllegalStateException("No cookies were received in the response.");
//        }
//        for (Cookie cookie : cookies) {
//            System.out.println("Cookie: " + cookie.getName() + "=" + cookie.getValue());
//        }
//        // Now, you have stored cookies that can be used in subsequent requests
//    }
//    @Test
//    @WithMockUser(username = "sajiyabro", roles = {"jOB_SEEKER"})
//    public void testSaveJobSeeker() throws Exception {
//        if (cookies == null) {
//            throw new IllegalStateException("No cookies available from the login response.");
//        }
//        JobSeekerRequest jobSeekerRequest = new JobSeekerRequest();
//        jobSeekerRequest.setFirst_name("John");
//        jobSeekerRequest.setLast_name("Doe");
//        jobSeekerRequest.setContact_number("1234567890");
//        jobSeekerRequest.setAddress("123 Main St");
//        jobSeekerRequest.setDob("1990-01-01");
//        jobSeekerRequest.setNic("ABC123456");
//        jobSeekerRequest.setGender("Male");
//        jobSeekerRequest.setJob_type("Full Time");
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/job-seeker/save")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(jobSeekerRequest))
//                .cookie(cookies))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//    @Test
//    @WithMockUser(username = "sajiyabro", roles = {"jOB_SEEKER"})
//    public void testDashboard() throws Exception {
//        // Perform the GET request and validate the response
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/job-seeker/dashboard"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andReturn();
//
//        String responseContent = result.getResponse().getContentAsString();
//
//        // You can now assert or parse the JSON response content as needed
//        // Example: Assert.assertTrue(responseContent.contains("expected_data"));
//    }
//    @Test
//
//    // Utility method to convert an object to JSON string
//    private static String asJsonString(final Object obj) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            return objectMapper.writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    private String buildCookieHeader(Cookie[] cookies) {
//        StringBuilder cookieHeader = new StringBuilder();
//
//        for (int i = 0; i < cookies.length; i++) {
//            Cookie cookie = cookies[i];
//            cookieHeader.append(cookie.getName()).append("=").append(cookie.getValue());
//
//            if (i < cookies.length - 1) {
//                cookieHeader.append("; ");
//            }
//        }
//
//        return cookieHeader.toString();
//    }
//}
