package main.java.com.funcooking;

import main.java.com.funcooking.component.ApplicationRunner;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        ApplicationRunner applicationRunner = new ApplicationRunner();
        applicationRunner.run();
        SCANNER.close();
    }

}
