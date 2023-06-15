package com.example.nutritionapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nutritionapi.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    void deleteByUsername(String username);
}
