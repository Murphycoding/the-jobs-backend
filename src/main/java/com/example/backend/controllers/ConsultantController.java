package com.example.backend.controllers;

import com.example.backend.models.Consultant;
import com.example.backend.models.User;
import com.example.backend.payload.request.ConsultantRequest;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.security.services.UserDetailsServiceImpl;
import com.example.backend.sevice.JwtService;
import com.example.backend.sevice.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/consultant")
public class ConsultantController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserService userService;

    @Autowired
    ConsultantRepository consultantRepository;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('CONSULTANT')")
    public Object dashboard(HttpServletRequest request) {

        return null;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('CONSULTANT') or hasRole('jOB_SEEKER')")
    public List<Consultant> all(HttpServletRequest request) {

        return consultantRepository.findAll();
    }

    @GetMapping("/profile/{cid}")
    @PreAuthorize("hasRole('CONSULTANT') or hasRole('jOB_SEEKER')")
    public Optional<Consultant> profile(@PathVariable Integer cid) {

        return consultantRepository.findById(Long.valueOf(cid));
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('CONSULTANT')")
    public Object save(HttpServletRequest request, @RequestBody ConsultantRequest consultantRequest) {

        String token = jwtService.getJwtFromCookies(request);
        System.out.println(token);
        String username = jwtService.getUserNameFromJwtToken(token);
        System.out.println(username);
        Optional<User> user = userService.findUserByUsername(username);

        Consultant consultant = new Consultant(
                consultantRequest.getSpecialized_area(),
                consultantRequest.getSpecialized_country(),
                consultantRequest.getFirst_name(),
                consultantRequest.getLast_name(),
                consultantRequest.getContact_number(),
                consultantRequest.getAddress(),
                consultantRequest.getDob(),
                consultantRequest.getNic(),
                consultantRequest.getGender(),
                consultantRequest.getJob_type(),
                user.orElse(new User())
        );
        return consultantRepository.save(consultant);
    }

}
