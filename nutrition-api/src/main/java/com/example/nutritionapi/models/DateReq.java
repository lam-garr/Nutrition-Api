package com.example.nutritionapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateReq {
    private String month;
    private int day;
    private int year;
    private String diaryId;
}
