package main.java.com.funcooking.component;

import main.java.com.funcooking.Main;
import main.java.com.funcooking.model.*;
import main.java.com.funcooking.utils.InputValidator;

import java.util.ArrayList;

public class RecipeWriter {
    private static final String MEASURE_PATTERN = "^(g|ml|pc)$";
    private static final String COMPLEXITY_PATTERN = "^(easy|e|medium|m|hard|h)$";
    private static final String YES_OR_NO = "^(y|yes|n|no)$";
    private static final String POSITIVE_INT_PATTERN = "^[1-9]+\\d*$";
    private static final String POSITIVE_NUMBER_PATTERN = "^(\\d*[\\.]?\\d*[1-9]+\\d*|[1-9]+\\d*[\\.]?\\d*)$";

    public Recipe writeRecipe(int recipeTypeChoice) {
        Recipe recipe = recipeOfType(recipeTypeChoice);

        System.out.print("Recipe title: ");
        assert recipe != null;
        recipe.setRecipeTitle(Main.SCANNER.nextLine().trim());

        System.out.println("Main ingredients list: ");
        recipe.setMainIngredients(buildIngredientsList());

        System.out.print("Do you want to add optional ingredients? (y/n): ");
        String answer = InputValidator.readAndValidateInput(YES_OR_NO,"yes(y) or no(n)");
        if (answer.equals("y") || answer.equals("yes")) {
            recipe.setOptionalIngredients(buildIngredientsList());
        } else {
            recipe.setOptionalIngredients(new ArrayList<>());
        }

        System.out.print("Preparation time in minutes: ");
        String preparationTimeString = InputValidator.readAndValidateInput(POSITIVE_INT_PATTERN,
                "positive integer number");
        recipe.setPreparationTime(Integer.parseInt(preparationTimeString));

        System.out.print("Cooking time in minutes: ");
        String cookingTimeString = InputValidator.readAndValidateInput(POSITIVE_INT_PATTERN,
                "positive integer number");
        recipe.setCookingTime(Integer.parseInt(cookingTimeString));

        recipe.setTotalTime();

        System.out.print("Complexity (easy/medium/hard): ");
        String complexityString = InputValidator.readAndValidateInput(COMPLEXITY_PATTERN,
                "easy(e) | medium (m) | hard (h)");
        recipe.setComplexity(Recipe.Complexity.fromString(complexityString));

        System.out.print("Is this recipe vegetarian? ");
        answer = InputValidator.readAndValidateInput(YES_OR_NO,"yes(y) or no(n)");
        recipe.setIsVegetarian(answer.equals("y") || answer.equals("yes"));

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

            System.out.print("Ingredient measure (g/ml/pc): ");
            String ingredientMeasure = InputValidator.readAndValidateInput(MEASURE_PATTERN,
                    "g/ml/pc").toUpperCase();

            System.out.print("Ingredient quantity: ");
            String ingredientQuantityString = InputValidator.readAndValidateInput(POSITIVE_NUMBER_PATTERN,
                    "positive number");
            double ingredientQuantity = Double.parseDouble(ingredientQuantityString);

            ingredients.add(new Ingredient(ingredientName, ingredientQuantity,
                    Ingredient.Measure.valueOf(ingredientMeasure)));

            System.out.print("Do you want to add more ingredients? ");
            String answer = InputValidator.readAndValidateInput(YES_OR_NO,
                    "yes(y) or no(n)");
            if (answer.equals("n") || answer.equals("no")) {
                continueAddIngredients = false;
            }
        }
        return ingredients;
    }

    private Recipe recipeOfType(int choice) {
        switch(choice) {
            case 1 -> { return new Recipe(Recipe.RecipeType.SOUP); }
            case 2 -> { return new Recipe(Recipe.RecipeType.MAIN_DISH); }
            case 3 -> { return new Recipe(Recipe.RecipeType.SALAD); }
            case 4 -> { return new Recipe(Recipe.RecipeType.BACKING); }
            case 5 -> { return new Recipe(Recipe.RecipeType.DESSERT); }
            case 6 -> { return new Recipe(Recipe.RecipeType.BEVERAGE); }
            default -> { return null; }
        }
    }
}
