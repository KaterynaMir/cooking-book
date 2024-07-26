package com.funcooking.utils;

import com.funcooking.Main;

public final class InputValidator {

    private InputValidator() {
    }

    public static String readAndValidateInput(String pattern, String validInputPrompt) {
        String userInput = Main.SCANNER.nextLine().trim().toLowerCase();
        while (true) {
            if (userInput.matches(pattern)) {
                return userInput;
            }
            System.out.println("Invalid input! Valid input is " + validInputPrompt + ".");
            System.out.print("Please, try again: ");
            userInput = Main.SCANNER.nextLine().trim().toLowerCase();
        }
    }
}
