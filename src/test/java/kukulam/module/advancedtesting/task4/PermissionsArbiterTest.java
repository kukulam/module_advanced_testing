package kukulam.module.advancedtesting.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class PermissionsArbiterTest {

    @Spy
    private AdminChecker spyAdminChecker = new AdminChecker();
    private PermissionsArbiter permissionsArbiter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        permissionsArbiter = new PermissionsArbiter(spyAdminChecker);
    }

    @Test
    void shouldCheckIfUserIsAnAdmin() {
        // given
        String login = "admin1";

        // when
        permissionsArbiter.validateAdmin(login);

        // then
        verify(spyAdminChecker, times(1)).isAdmin(login);
    }

    // manual creating spy
    @Test
    void shouldCheckIfUserIsAnAdmin2() {
        // given
        String login = "admin1";

        AdminChecker spyAdminChecker = Mockito.spy(new AdminChecker());
        PermissionsArbiter permissionsArbiter = new PermissionsArbiter(spyAdminChecker);

        // when
        permissionsArbiter.validateAdmin(login);

        // then
        verify(spyAdminChecker, times(1)).isAdmin(login);
    }

    @Test
    void shouldThrowExceptionWhenUserIsNotAdmin() {
        // given
        String login = "user1";

        // when && then
        assertThatThrownBy(() -> permissionsArbiter.validateAdmin(login)).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldReturnAdminPermissions() {
        // given
        String login = "admin1";
        String[] expectedPermissions = new String[] { "read", "write" };

        // when
        List<String> permissions = permissionsArbiter.permissions(login);

        // then
        assertThat(permissions).containsExactlyInAnyOrder(expectedPermissions);
    }

    @Test
    void shouldReturnUserPermissions() {
        // given
        String login = "user1";
        String[] expectedPermissions = new String[] { "read" };

        // when
        List<String> permissions = permissionsArbiter.permissions(login);

        // then
        assertThat(permissions).containsExactlyInAnyOrder(expectedPermissions);
    }

}