package main.java.com.funcooking.utils;

import main.java.com.funcooking.Main;

public class InputValidator {
    public static String readAndValidateInput(String pattern, String validInputPrompt) {
        String userInput = Main.SCANNER.nextLine().trim().toLowerCase();
        while(true) {
            if (userInput.matches(pattern)) {
                return userInput;
            }
            System.out.println("Invalid input! Valid input is " + validInputPrompt + ".");
            System.out.print("Please, try again: ");
            userInput = Main.SCANNER.nextLine().trim().toLowerCase();
        }
    }
}
