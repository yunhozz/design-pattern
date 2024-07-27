package _SOLID._1_single_responsibility.compliant;

import _SOLID._1_single_responsibility.User;

public class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final UserActivityLogger userActivityLogger;

    public UserService(
            UserRepository userRepository,
            EmailService emailService,
            UserActivityLogger userActivityLogger
    ) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userActivityLogger = userActivityLogger;
    }

    public void registerUser(User user) {
        userRepository.saveUser(user);
        emailService.sendWelcomeEmail(user);
        userActivityLogger.logUserActivity(user);
    }
}
