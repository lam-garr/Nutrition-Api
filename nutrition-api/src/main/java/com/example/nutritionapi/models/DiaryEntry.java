package com.example.nutritionapi.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiaryEntry implements Comparable<DiaryEntry> {
    private String id;
    private String day;
    private int calories;
    private List<NutritionInfo> diary;

    @Override
    public int compareTo(DiaryEntry diaryEntry) {
        if(this.calories == diaryEntry.getCalories()) {
            return 0;
        } else if(this.calories > diaryEntry.getCalories()) {
            return 1;
        } else {
            return -1;
        }
    }
}
