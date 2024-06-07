package main.java.com.funcooking.component;

import main.java.com.funcooking.Main;
import main.java.com.funcooking.model.*;

import java.time.Duration;
import java.util.ArrayList;

public class RecipeWriter {
    public Recipe writeRecipe(int recipeType) {
        Recipe recipe = recipeOfType(recipeType);

        System.out.print("Recipe title: ");
        assert recipe != null;
        recipe.setRecipeTitle(Main.SCANNER.nextLine().trim());

        System.out.println("Main ingredients list: ");
        recipe.setMainIngredients(buildIngredientsList());

        System.out.print("Do you want to add optional ingredients? (y/n): ");
        String answer = Main.SCANNER.nextLine().trim().toLowerCase();
        if (answer.equals("y")) {
            recipe.setOptionalIngredients(buildIngredientsList());
        } else {
            recipe.setOptionalIngredients(new ArrayList<>());
        }

        System.out.print("Preparation time in minutes: ");
        recipe.setPreparationTime(Duration.ofMinutes(Long.parseLong(Main.SCANNER.nextLine())));

        System.out.print("Cooking time in minutes: ");
        recipe.setCookingTime(Duration.ofMinutes(Long.parseLong(Main.SCANNER.nextLine())));

        recipe.setTotalTime();

        System.out.print("Complexity (EASY/MEDIUM/HARD): ");
        recipe.setComplexity(Recipe.Complexity.valueOf(Main.SCANNER.nextLine().trim().toUpperCase()));

        System.out.print("Is this recipe vegetarian? ");
        answer = Main.SCANNER.nextLine().trim().toLowerCase();
        recipe.setIsVegetarian(answer.equals("y"));

        System.out.print("Instructions: ");
        recipe.setInstructions(Main.SCANNER.nextLine().trim());

        return recipe;
    }

    private ArrayList<Ingredient> buildIngredientsList() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        boolean continueAddIngredients = true;
        while (continueAddIngredients) {

            System.out.print("Ingredient name: ");
            String ingredientName = Main.SCANNER.nextLine().trim().toLowerCase();

            System.out.print("Ingredient measure (G/ML/PC): ");
            String ingredientMeasure = Main.SCANNER.nextLine().trim().toUpperCase();

            System.out.print("Ingredient quantity: ");
            double ingredientQuantity = Double.parseDouble(Main.SCANNER.nextLine());

            ingredients.add(new Ingredient(ingredientName, ingredientQuantity,
                    Ingredient.Measure.valueOf(ingredientMeasure)));

            System.out.print("Do you want to add more ingredients? ");
            String answer = Main.SCANNER.nextLine().trim().toLowerCase();
            if (answer.equals("n")) {
                continueAddIngredients = false;
            }
        }
        return ingredients;
    }

    private Recipe recipeOfType(int choice) {
        switch(choice) {
            case 1 -> { return new Soup(); }
            case 2 -> { return new MainDish(); }
            case 3 -> { return new Salad(); }
            case 4 -> { return new Baking(); }
            case 5 -> { return new Dessert(); }
            default -> { return null; }
        }
    }
}
