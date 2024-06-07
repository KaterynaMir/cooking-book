package main.java.com.funcooking.component;

import static main.java.com.funcooking.Main.SCANNER;
public class RecipesMenu {

    public int printMenu () {
        System.out.print("""
                Which type of recipe do you want to add?
                Please enter:\s
                \t1 - for Soup
                \t2 - for MainDish
                \t3 - for Salad
                \t4 - for Baking
                \t5 - for Dessert
                :\s""");
        String choice = checkAndValidateAnswer(SCANNER.nextLine());
        return Integer.parseInt(choice);
    }

    private String checkAndValidateAnswer(String answer) {
        answer = answer.trim();
        while(!answer.matches("^[1-5]$")) {
            System.out.print("Invalid choice. Please, try again: ");
            answer = SCANNER.nextLine().trim();
        }
        return answer;
    }

}
