package kukulam.module.advancedtesting.task4;

import java.util.Arrays;
import java.util.List;

public class AdminChecker {
    private static final List<String> ADMINS = Arrays.asList(
            "admin1",
            "admin2",
            "admin3"
    );

    public boolean isAdmin(String login) {
        return ADMINS.contains(login);
    }
}
