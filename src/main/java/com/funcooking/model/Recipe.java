package com.funcooking.model;

import java.util.ArrayList;

public class Recipe {
    public static int numRecipes = 0;
    private final int recipeID;
    private RecipeType recipeType;
    private String recipeTitle;
    private ArrayList<Ingredient> mainIngredients;          // non-empty list
    private ArrayList<Ingredient> optionalIngredients;      // can be empty
    private String instructions;
    private int preparationTime = 0;
    private int cookingTime = 0;
    private int totalTime;
    private Complexity complexity;
    boolean isVegetarian;
    private String author;

    public Recipe() {
        numRecipes += 1;
        this.recipeID = numRecipes;
    }

    public Recipe(RecipeType recipeType) {
        numRecipes += 1;
        this.recipeID = numRecipes;
        this.recipeType = recipeType;
    }

    public Recipe(RecipeType recipeType, ArrayList<Ingredient> mainIngredients, ArrayList<Ingredient> optionalIngredients,
                  String instructions, int preparationTime, int cookingTime,
                  Complexity complexity, boolean isVegetarian, String author) {
        this.recipeType = recipeType;
        this.mainIngredients = mainIngredients;
        this.optionalIngredients = optionalIngredients;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.totalTime = preparationTime + cookingTime;
        this.complexity = complexity;
        this.isVegetarian = isVegetarian;
        this.author = author;
        numRecipes += 1;
        this.recipeID = numRecipes;
    }

    @Override
    public String toString() {
        return "\tRecipe ID: " + recipeID +
                "\n\tRecipe type: " + recipeType.toString().toLowerCase() +
                "\n\tRecipe Title: " + recipeTitle +
                "\n\n\tMain ingredients: " + buildStringFromIngredientsList(mainIngredients) +
                "\n\n\tOptional ingredients: " + buildStringFromIngredientsList(optionalIngredients) +
                "\n\n\tInstructions: '" + instructions + '\'' +
                "\n\n\tPreparation time = " + preparationTime + " min" +
                "\n\tCooking time = " + cookingTime + " min" +
                "\n\tTotal time = " + totalTime + " min" +
                "\n\n\tComplexity = " + complexity.toString().toLowerCase() +
                "\n\tisVegetarian = " + isVegetarian +
                "\n\n\tAuthor: " + author;
    }

    private String buildStringFromIngredientsList(ArrayList<Ingredient> ingredients) {
        StringBuilder ingredientsString = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            ingredientsString.append("\n\t")
                    .append(ingredient);
        }
        return ingredientsString.toString();
    }

    public int getRecipeID() {
        return recipeID;
    }

    public RecipeType getRecipeType() {
        return recipeType;
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

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime() {
        totalTime = preparationTime + cookingTime;
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
        EASY("e"), MEDIUM("m"), HARD("h"), UNDEFINED("u");

        private final String shortForm;

        Complexity(String shortForm) {
            this.shortForm = shortForm;
        }

        private String getShortForm() {
            return shortForm;
        }

        public static Complexity fromString(String complexityString) {
            for (Complexity complexity : values()) {
                if (complexity.toString().equals(complexityString.toUpperCase()) ||
                        complexity.getShortForm().equals(complexityString)) {
                    return complexity;
                }
            }
            return UNDEFINED;
        }
    }

    public enum RecipeType {
        SOUP, MAIN_DISH, SALAD, DESSERT, BACKING, BEVERAGE
    }
}
