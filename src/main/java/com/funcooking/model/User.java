package main.java.com.funcooking.model;

public class User {
    private final String firstName;
    private final String lastName;
    private final String fullName;
    private final String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fullName = firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "User {"
                + "\tfullName = " + fullName
                + ", email = " + email
                + "\t}";
    }
}
