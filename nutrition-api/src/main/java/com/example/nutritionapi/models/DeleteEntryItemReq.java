package com.example.nutritionapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteEntryItemReq {
    private int diaryId;
    private int deleteEntryItemId;
}
