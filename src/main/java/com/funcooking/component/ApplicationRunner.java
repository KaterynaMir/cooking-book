package main.java.com.funcooking.component;

import main.java.com.funcooking.model.User;
import main.java.com.funcooking.service.UserService;

public class ApplicationRunner {
    private final UserService userService = new UserService();

    public void run() {
        if (Authenticator.auth()) {
            User user = userService.registerNewUser();
        }
    }
}
