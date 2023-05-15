package com.example.nutritionapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    
    @GetMapping(path="/")
    public String getRootHome() {
        return "Welcome to nutrition api.";
    }
}
