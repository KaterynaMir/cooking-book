package main.java.com.funcooking.model;

import java.time.Duration;
import java.util.ArrayList;
public abstract class Recipe {
    static int numRecipes = 0;
    private final int recipeID;
    private String recipeTitle;
    private ArrayList<Ingredient> mainIngredients;          // non-empty list
    private ArrayList<Ingredient> optionalIngredients;      // can be empty
    private String instructions;
    private Duration preparationTime = Duration.ofMinutes(0);
    private Duration cookingTime = Duration.ofMinutes(0);
    private Duration totalTime;
    private Complexity complexity;
    boolean isVegetarian;
    private String author;

    public Recipe() {
        numRecipes += 1;
        recipeID = numRecipes;
    }

    public Recipe(ArrayList<Ingredient> mainIngredients, ArrayList<Ingredient> optionalIngredients,
                  String instructions, Duration preparationTime, Duration cookingTime,
                  Complexity complexity, boolean isVegetarian, String author) {
        this.mainIngredients = mainIngredients;
        this.optionalIngredients = optionalIngredients;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.totalTime = preparationTime.plus(cookingTime);
        this.complexity = complexity;
        this.isVegetarian = isVegetarian;
        this.author = author;
        numRecipes += 1;
        recipeID = numRecipes;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public ArrayList<Ingredient> getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(ArrayList<Ingredient> mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public ArrayList<Ingredient> getOptionalIngredients() {
        return optionalIngredients;
    }

    public void setOptionalIngredients(ArrayList<Ingredient> optionalIngredients) {
        this.optionalIngredients = optionalIngredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Duration getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Duration preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Duration getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Duration cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public void setTotalTime() {
        totalTime = preparationTime.plus(cookingTime);
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public boolean getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public enum Complexity {
        EASY, MEDIUM, HARD
    }
}