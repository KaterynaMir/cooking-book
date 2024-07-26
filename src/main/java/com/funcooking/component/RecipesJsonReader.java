package com.funcooking.component;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.funcooking.model.Recipe;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipesJsonReader {
    private final Gson gson = new Gson();

    public List<Recipe> readRecipesFromJson(String filePath) {
        try {
            JsonReader reader = new JsonReader(new FileReader(filePath));
            Recipe[] recipes = gson.fromJson(reader, Recipe[].class);
            return new ArrayList<>(Arrays.asList(recipes));
        } catch (IOException e) {
            System.out.println("Can't read the cooking book: " + filePath + "." +
                    "\nCreating an empty recipes list.");
            return new ArrayList<>();
        }
    }

}
