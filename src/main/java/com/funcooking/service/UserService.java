package main.java.com.funcooking.service;

import main.java.com.funcooking.model.User;
import main.java.com.funcooking.utils.InputValidator;

public class UserService {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z-]+$";
    public User registerNewUser(){
        System.out.println("Please, provide user information.");
        System.out.print("Email: ");
        String email = InputValidator.readAndValidateInput(EMAIL_PATTERN, "example@gmail.com");
        System.out.print("Fist name: ");
        String firstName = InputValidator.readAndValidateInput(NAME_PATTERN,
                "at least one letter or hyphen and no spaces");
        System.out.print("Last name: ");
        String lastName = InputValidator.readAndValidateInput(NAME_PATTERN,
                "at least one letter or hyphen and no spaces");
        User user = new User(capitalizeName(firstName),
                            capitalizeName(lastName),
                            email);
        System.out.println("New user has been successfully registered!\n" + user);
        return user;
    }

    private static String capitalizeName(String name) {
        StringBuilder capitalizedName = new StringBuilder(name.substring(0, 1).toUpperCase());
        int index = name.indexOf("-");
        int continueSearchIndex = 1;
        while (index > -1 && index < name.length() - 1) {
            capitalizedName.append(name, continueSearchIndex, index + 1);
            capitalizedName.append(name.substring(index + 1, index + 2).toUpperCase());
            continueSearchIndex = index + 2;
            index = name.indexOf("-", continueSearchIndex);
        }
        capitalizedName.append(name.substring(continueSearchIndex));
        return capitalizedName.toString();
    }
}
