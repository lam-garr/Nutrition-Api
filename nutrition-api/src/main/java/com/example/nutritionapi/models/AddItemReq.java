package com.example.nutritionapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItemReq {
    private String item;
    private String id;
    private String sortBy;
}
