package _SOLID._1_single_responsibility.non_compliant;

import _SOLID._1_single_responsibility.User;

public class UserService {

    public void saveUser(User user) {
        System.out.println("User saved to database: " + user.getName());
    }

    public void sendWelcomeEmail(User user) {
        System.out.println("Welcome email sent to: " + user.getEmail());
    }

    public void logUserActivity(User user) {
        System.out.println("Logging activity for user: " + user.getName());
    }

    public void registerUser(User user) {
        saveUser(user);
        sendWelcomeEmail(user);
        logUserActivity(user);
    }
}
