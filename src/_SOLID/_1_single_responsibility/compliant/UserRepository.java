package _SOLID._1_single_responsibility.compliant;

import _SOLID._1_single_responsibility.User;

public class UserRepository {

    public void saveUser(User user) {
        System.out.println("User saved to database: " + user.getName());
    }
}
