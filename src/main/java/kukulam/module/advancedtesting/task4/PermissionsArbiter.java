package kukulam.module.advancedtesting.task4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Use in tests: @Spy, Mockito.spy, Mockito.verify, containsExactlyInAnyOrder, assertThatThrownBy
public class PermissionsArbiter {
    private static final List<String> ADMIN_PERMISSIONS = Arrays.asList("read", "write");
    private static final List<String> USER_PERMISSIONS = Collections.singletonList("read");

    private final AdminChecker adminChecker;

    public PermissionsArbiter(AdminChecker adminChecker) {
        this.adminChecker = adminChecker;
    }

    public List<String> permissions(String login) {
        if (adminChecker.isAdmin(login)) {
            return ADMIN_PERMISSIONS;
        } else {
            return USER_PERMISSIONS;
        }
    }

    public void validateAdmin(String login) {
        if (!adminChecker.isAdmin(login)) {
            throw new RuntimeException("User is not an admin !");
        }
    }
}
