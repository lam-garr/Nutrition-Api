package com.example.nutritionapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NutritionInfo implements Comparable<NutritionInfo>{
    private int id;
    private String name;
    private Nutrient ENERC_KCAL;
    private Nutrient FAT;
    private Nutrient FASAT;
    private Nutrient FATRN;
    private Nutrient FAMS;
    private Nutrient FAPU;
    private Nutrient CHOCDF;
    private Nutrient FIBTG;
    private Nutrient SUGAR;
    private Nutrient PROCNT;
    private Nutrient CHOLE;
    private Nutrient NA;
    private Nutrient CA;
    private Nutrient MG;
    private Nutrient K;
    private Nutrient FE;
    private Nutrient ZN;
    private Nutrient P;
    private Nutrient VITA_RAE;
    private Nutrient VITC;
    private Nutrient THIA;
    private Nutrient RIBF;
    private Nutrient NIA;
    private Nutrient VITB6A;
    private Nutrient FOLDFE;
    private Nutrient FOLDFD;
    private Nutrient FOLAC;
    private Nutrient VITB12;
    private Nutrient VITD;
    private Nutrient TOCPHA;
    private Nutrient VITK1;
    private Nutrient WATER;

    @Override
    public int compareTo(NutritionInfo nutritionInfo) {
        if(this.ENERC_KCAL.getQuantity() == nutritionInfo.getENERC_KCAL().getQuantity()) {
            return 0;
        } else if(this.ENERC_KCAL.getQuantity() > nutritionInfo.getENERC_KCAL().getQuantity()) {
            return 1;
        } else {
            return -1;
        }
    }
}
