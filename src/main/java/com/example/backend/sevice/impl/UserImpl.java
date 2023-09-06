package com.example.backend.sevice.impl;

import com.example.backend.models.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        return userOptional;
    }

    @Override
    public Boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);

    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user){
        return  userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
