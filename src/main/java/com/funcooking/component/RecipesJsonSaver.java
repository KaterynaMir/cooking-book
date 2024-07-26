package com.funcooking.component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.funcooking.model.Recipe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RecipesJsonSaver {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void writeRecipesAsJson(List<Recipe> recipes, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            gson.toJson(recipes, writer);
            writer.flush();
            writer.close();
            System.out.println("Saving recipes to the cooking book...");
            System.out.println("Cooking book size: " + recipes.size() + " recipes");
        } catch (IOException e) {
            System.out.println("Can't write to the file: " + filePath);
        }
    }
}
