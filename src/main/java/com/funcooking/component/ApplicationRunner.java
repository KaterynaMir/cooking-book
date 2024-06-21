package main.java.com.funcooking.component;

import main.java.com.funcooking.model.Recipe;
import main.java.com.funcooking.model.User;
import main.java.com.funcooking.service.UserService;

import java.util.List;

public class ApplicationRunner {
    private final UserService userService = new UserService();
    private final RecipesMenu recipesMenu = new RecipesMenu();
    private final RecipeWriter recipeWriter = new RecipeWriter();
    private final RecipesJsonReader recipesJsonReader = new RecipesJsonReader();
    private final RecipesJsonSaver recipesJsonSaver = new RecipesJsonSaver();
    private final String cookingBookPath = "cookingBook.txt";

    public void run() {
        if (Authenticator.auth()) {
            User user = userService.registerNewUser();
            List<Recipe> cookingBook = recipesJsonReader.readRecipesFromJson(cookingBookPath);
            Recipe.numRecipes = cookingBook.isEmpty() ? 0 : cookingBook.getLast().getRecipeID();
            int choice = recipesMenu.printMenu();
            Recipe recipe = recipeWriter.writeRecipe(choice);
            recipe.setAuthor(user.getFullName());
            user.addRecipe(recipe);
            cookingBook.add(recipe);
            System.out.println("Cooking book size: " + cookingBook.size());
            recipesJsonSaver.writeRecipesAsJson(cookingBook,cookingBookPath);
            System.out.println(recipe);

        }
    }
}
