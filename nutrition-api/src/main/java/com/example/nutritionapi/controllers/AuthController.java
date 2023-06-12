package com.example.nutritionapi.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nutritionapi.models.LoginReq;
import com.example.nutritionapi.models.LoginRes;
import com.example.nutritionapi.security.JwtIssuer;
import com.example.nutritionapi.security.UserPrincipal;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;

    private final AuthenticationManager authenticationManager;
    
    @GetMapping("/login")
    public LoginRes login(){
        var authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken("Username", "password")
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var principal = (UserPrincipal) authentication.getPrincipal();

        var token = jwtIssuer.issue(principal.getUserId(), principal.getUsername());

        return LoginRes.builder()
            .accessToken(token)
            .build();
    }
}
