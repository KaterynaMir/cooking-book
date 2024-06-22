package main.java.com.funcooking.component;

import main.java.com.funcooking.utils.InputValidator;

public class UserActionsMenu {
    public int printUserMenu () {
        System.out.print("""
                \n-----------------------------------------------------------
                What do you want to do?
                Please enter:\s
                \t1 - print cooking book content
                \t2 - search for recipe by title
                \t3 - search for recipe by ingredient
                \t4 - print recipe by RecipeId
                \t5 - add recipe
                \t6 - edit recipe by RecipeId
                \t7 - exit
                :\s""");
        String choice = InputValidator.readAndValidateInput("^[1-7]$",
                "1/2/3/4/5/6/7");
        return Integer.parseInt(choice);
    }
}
