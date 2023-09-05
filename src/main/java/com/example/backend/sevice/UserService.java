package com.example.backend.sevice;

import com.example.backend.models.User;

import java.util.Optional;

public interface UserService {

    //Optional<User> findByUsername(String username);

    Optional<User> findUserByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User save(User user);
}
