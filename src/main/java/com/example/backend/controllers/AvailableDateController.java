package com.example.backend.controllers;

import com.example.backend.models.AvailableDate;
import com.example.backend.models.Consultant;
import com.example.backend.models.User;
import com.example.backend.payload.request.AvailableDateRequest;
import com.example.backend.repository.AvailableDateRepository;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.jwt.JwtUtils;
import com.example.backend.security.services.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/available_time")
public class AvailableDateController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @Autowired
    AvailableDateRepository availableDateRepository;

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    ConsultantRepository consultantRepository;
    @GetMapping("/consultant/{cid}")
    @PreAuthorize("hasRole('CONSULTANT') or hasRole('jOB_SEEKER')")
    public List<AvailableDate> all(@PathVariable Integer cid) {

        return availableDateRepository.findByConsultantId(Long.valueOf(cid));
    }
    @PostMapping("/save")
    @PreAuthorize("hasRole('CONSULTANT')")
    public ResponseEntity<String> save(HttpServletRequest request , @RequestBody List<AvailableDateRequest> availableDateRequest) {
        String token = jwtUtils.getJwtFromCookies(request);
        String username = jwtUtils.getUserNameFromJwtToken(token);
        Optional<User> user = userRepository.findByUsername(username);
        Optional<Consultant> consultant = consultantRepository.findByUser(user.orElse(new User()));

//        return  consultant;
        for (AvailableDateRequest requestData : availableDateRequest) {
            String date = requestData.getDate();
            String startTime = requestData.getStart_time();
            String endTime = requestData.getEnd_time();

            System.out.println("Date: " + date);
            System.out.println("Start Time: " + startTime);
            System.out.println("End Time: " + endTime);
            System.out.println("Start datetime: " + date + " " + startTime);
            System.out.println("End datetime: " + date + " " + endTime);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalDateTime start = LocalDateTime.parse(date + " " + startTime, formatter);
            LocalDateTime end = LocalDateTime.parse(date + " " + endTime, formatter);

            System.out.println("Start datetime: " + start);
            System.out.println("End datetime: " + end);

            AvailableDate availableDate = new AvailableDate(
                    start,
                    end,
                    consultant.orElse(new Consultant())
            );
//            System.out.println( availableDate.toString() );
            availableDateRepository.save(availableDate);
        }

        return ResponseEntity.ok("Data inserted successfully");
    }
}
