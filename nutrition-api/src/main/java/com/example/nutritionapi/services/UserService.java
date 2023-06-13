package com.example.nutritionapi.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.nutritionapi.entity.UserEntity;

@Service
public class UserService {
    private static final String EXIST_NAME = "Username";

    public Optional<UserEntity> findByUsername(String username){
        if(!EXIST_NAME.equalsIgnoreCase(username)) return Optional.empty();

        var user = new UserEntity();

        user.setId(123456789);
        user.setUsername(EXIST_NAME);
        user.setPassword(new BCryptPasswordEncoder().encode("password"));
        return Optional.of(user);
    }
}
