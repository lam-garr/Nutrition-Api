package com.example.nutritionapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private int id;
    private String username;
    @JsonIgnore
    private String password;
}
