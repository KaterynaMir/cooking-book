package main.java.com.funcooking.service;

import main.java.com.funcooking.Main;
import main.java.com.funcooking.model.User;

public class UserService {
    public User registerNewUser(){
        System.out.println("Please, provide user information.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        System.out.print("Fist name: ");
        String firstName = Main.SCANNER.nextLine();
        System.out.print("Last name: ");
        String lastName = Main.SCANNER.nextLine();
        User user = new User(firstName,lastName,email);
        System.out.println("New user has been successfully registered!\n" + user);
        return user;
    }
}
