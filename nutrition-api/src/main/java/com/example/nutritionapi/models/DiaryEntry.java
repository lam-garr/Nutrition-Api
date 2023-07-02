package com.example.nutritionapi.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiaryEntry {
    private String id;
    private String day;
    private int calories;
    private List<NutritionInfo> diary;
}
