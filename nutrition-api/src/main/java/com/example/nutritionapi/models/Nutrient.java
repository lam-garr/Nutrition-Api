package com.example.nutritionapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Nutrient {
    private String label;
    private int quantity;
    private String unit;

    public Nutrient(String label, int quantity, String unit) {
        this.label = label;
        this.quantity = quantity;
        this.unit = unit;
    }
}
