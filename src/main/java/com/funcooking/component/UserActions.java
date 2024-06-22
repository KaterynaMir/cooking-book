package main.java.com.funcooking.component;

import main.java.com.funcooking.Main;
import main.java.com.funcooking.model.Recipe;
import main.java.com.funcooking.model.User;
import main.java.com.funcooking.service.RecipeService;

import java.util.List;

public class UserActions {
    private final RecipesMenu recipesMenu = new RecipesMenu();
    private final RecipeWriter recipeWriter = new RecipeWriter();
    public boolean userAction(User user, int menuChoice, List<Recipe> cookingBook) {
        boolean continueAction = true;
        switch(menuChoice) {
            case 1 -> cookingBook.forEach(recipe -> System.out.println(recipe.getRecipeID()
                    + " " + recipe.getRecipeTitle()));
            case 2 -> {
                System.out.print("Please, enter search pattern for recipe title: ");
                String pattern = Main.SCANNER.nextLine().trim().toLowerCase();
                cookingBook.stream()
                        .filter(recipe -> recipe.getRecipeTitle().toLowerCase().contains(pattern))
                        .forEach(recipe -> System.out.println(recipe.getRecipeID()
                                + " " + recipe.getRecipeTitle()));
            }
            case 3 -> {
                System.out.print("Please, enter search pattern for ingredient: ");
                String pattern = Main.SCANNER.nextLine().trim().toLowerCase();
                cookingBook.stream()
                        .filter(recipe -> recipe.getMainIngredients().stream()
                                .anyMatch(ingredient -> ingredient.getName().contains(pattern)))
                        .forEach(recipe -> System.out.println(recipe.getRecipeID()
                                + " " + recipe.getRecipeTitle()));
            }
            case 4 -> {
                int recipeId = RecipeService.getValidRecipeId(cookingBook);
                System.out.println(cookingBook.get(recipeId - 1));
            }
            case 5 -> {
                int choice = recipesMenu.printMenu();
                Recipe recipe = recipeWriter.writeRecipe(choice);
                recipe.setAuthor(user.getFullName());
                user.addRecipe(recipe);
                cookingBook.add(recipe);
                System.out.println("New recipe has been added: " + recipe.getRecipeID() + " " + recipe.getRecipeTitle());
            }
            case 6 -> {
                int recipeId = RecipeService.getValidRecipeId(cookingBook);
                //implement edit recipe
            }
            case 7 -> continueAction = false;

        }
        return continueAction;
    }
}
