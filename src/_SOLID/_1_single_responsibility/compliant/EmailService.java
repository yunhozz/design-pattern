package _SOLID._1_single_responsibility.compliant;

import _SOLID._1_single_responsibility.User;

public class EmailService {

    public void sendWelcomeEmail(User user) {
        System.out.println("Welcome email sent to: " + user.getEmail());
    }
}
