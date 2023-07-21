package com.example.nutritionapi.models;

import java.util.Comparator;

public class SortByKcalDescend implements Comparator<DiaryEntry>{
    public int compare(DiaryEntry entry1, DiaryEntry entry2) {
        return Integer.valueOf(entry1.getCalories()).compareTo(entry2.getCalories());
    }
}
