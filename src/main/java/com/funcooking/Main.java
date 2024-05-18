package main.java.com.funcooking;

import java.util.Scanner;

public class Main {

    static final String PASSWORD = "cook";
    static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        run();
    }

    static void run() {
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
    }
}
