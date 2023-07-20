package com.example.nutritionapi.models;

import java.util.Comparator;

public class SortByKcal implements Comparator<DiaryEntry>{
    public int compare(DiaryEntry entry1, DiaryEntry entry2) {
        return entry1.getCalories() - entry2.getCalories();
    }
}
