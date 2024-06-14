package main.java.com.funcooking.component;

import main.java.com.funcooking.model.Recipe;
import main.java.com.funcooking.model.User;
import main.java.com.funcooking.service.UserService;

public class ApplicationRunner {
    private final UserService userService = new UserService();
    private final RecipesMenu recipesMenu = new RecipesMenu();
    private final RecipeWriter recipeWriter = new RecipeWriter();

    public void run() {
        if (Authenticator.auth()) {
            User user = userService.registerNewUser();
            int choice = recipesMenu.printMenu();
            Recipe recipe = recipeWriter.writeRecipe(choice);
            recipe.setAuthor(user.getFullName());
            user.addRecipe(recipe);
            System.out.println("New recipe added: " + recipe.getRecipeID() + " - "
                    + recipe.getRecipeTitle());
            System.out.println(recipe);
        }
    }
}
