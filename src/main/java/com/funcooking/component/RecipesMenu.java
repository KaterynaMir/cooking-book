package com.funcooking.component;

import com.funcooking.utils.InputValidator;

public class RecipesMenu {

    public int printMenu() {
        System.out.print("""
                Which type of recipe do you want to add?
                Please enter:\s
                \t1 - for Soup
                \t2 - for MainDish
                \t3 - for Salad
                \t4 - for Baking
                \t5 - for Dessert
                \t6 - for Beverage
                :\s""");
        String choice = InputValidator.readAndValidateInput("^[1-6]$",
                "1/2/3/4/5/6");
        return Integer.parseInt(choice);
    }

}
