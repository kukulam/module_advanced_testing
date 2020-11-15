package kukulam.module.advancedtesting.task2;

import java.util.List;

// Use in tests: assertThrows, assertThatThrownBy, assertDoesNotThrow
public class StringJoiner {

    public String create(List<String> arguments) {
        if (arguments == null)
            throw new NullPointerException("List with arguments == null !");
        if (arguments.size() == 0)
            throw new IllegalArgumentException("List with arguments is empty !");

        StringBuilder result = new StringBuilder(arguments.get(0));

        for (int i = 1; i < arguments.size(); i++) {
            result.append(arguments.get(i));
        }

        return result.toString();
    }
}
