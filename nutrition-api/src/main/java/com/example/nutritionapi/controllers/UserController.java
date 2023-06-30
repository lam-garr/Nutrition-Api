package com.example.nutritionapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nutritionapi.models.User;
import com.example.nutritionapi.security.UserPrincipal;
import com.example.nutritionapi.services.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping(path="/")
    public String getRootHome() {
        return "Welcome to nutrition api.";
    }

    @GetMapping("username")
    public String getUserId(@AuthenticationPrincipal UserPrincipal principal) {
        return principal.getUsername();
    }

    @GetMapping(path="/delete-user")
    public void deleteUser(){
        userService.deleteUser("");
        return;
    }
}
