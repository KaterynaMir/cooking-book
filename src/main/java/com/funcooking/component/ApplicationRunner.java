package com.funcooking.component;

import com.funcooking.model.Recipe;
import com.funcooking.model.User;
import com.funcooking.service.UserService;

import java.util.List;

public class ApplicationRunner {
    private final UserService userService = new UserService();
    private final RecipesJsonReader recipesJsonReader = new RecipesJsonReader();
    private final RecipesJsonSaver recipesJsonSaver = new RecipesJsonSaver();
    private final UserActionsMenu userActionsMenu = new UserActionsMenu();
    private final UserActions userActions = new UserActions();
    private final String cookingBookPath = "cookingBook.txt";

    public void run() {
        if (Authenticator.auth()) {
            User user = userService.registerNewUser();
            List<Recipe> cookingBook = recipesJsonReader.readRecipesFromJson(cookingBookPath);
            Recipe.numRecipes = cookingBook.isEmpty() ? 0 : cookingBook.getLast().getRecipeID();
            boolean continueUserAction = true;
            while (continueUserAction) {
                int choice = userActionsMenu.printUserMenu();
                continueUserAction = userActions.userAction(user, choice, cookingBook);
            }
            recipesJsonSaver.writeRecipesAsJson(cookingBook, cookingBookPath);
        }
    }
}
