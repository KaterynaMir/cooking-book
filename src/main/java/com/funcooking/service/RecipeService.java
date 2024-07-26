package com.funcooking.service;

import com.funcooking.model.Recipe;
import com.funcooking.utils.InputValidator;

import java.util.List;

public class RecipeService {
    public static int getValidRecipeId(List<Recipe> cookingBook) {
        System.out.print("Please, enter RecipeId: ");
        int cookingBookSize = cookingBook.size();
        int recipeId = Integer.parseInt(InputValidator.readAndValidateInput("^[1-9]+\\d*$",
                "positive integer < " + cookingBookSize));
        while (recipeId > cookingBookSize) {
            System.out.println("The input " + recipeId + " is invalid: there are only " + cookingBookSize
                    + " recipes in the cooking book.");
            System.out.print("Please, try again. RecipeId: ");
            recipeId = Integer.parseInt(InputValidator.readAndValidateInput("^[1-9]+\\d*$",
                    "positive integer < " + cookingBookSize));
        }
        return recipeId;
    }
}
