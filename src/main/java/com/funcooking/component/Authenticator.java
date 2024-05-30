package main.java.com.funcooking.component;

import static main.java.com.funcooking.Main.SCANNER;

public class Authenticator {
    private static final String PASSWORD = "cook";

    public static boolean auth(){
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();
            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password");
            }
        }
        System.out.println(accepted ? "Hello, master Chief!" : "Application has been blocked.");
        return accepted;
    }
}
