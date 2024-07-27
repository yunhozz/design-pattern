package _SOLID._1_single_responsibility.compliant;

import _SOLID._1_single_responsibility.User;

public class UserActivityLogger {

    public void logUserActivity(User user) {
        System.out.println("Logging activity for user: " + user.getName());
    }
}
