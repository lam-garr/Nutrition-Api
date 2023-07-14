package com.example.nutritionapi.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="NutritionUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String token;
    private List<DiaryEntry> myData;
}
