package com.example.nutritionapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupReq {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
