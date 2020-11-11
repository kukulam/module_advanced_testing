package kukulam.module.advancedtesting.task2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringJoinerTest {

    @Test
    void shouldThrowExceptionWhenInputParamsIsNull() {
        // given
        StringJoiner stringJoiner = new StringJoiner();
        List<String> arguments = null;

        // when && then
        assertThrows(NullPointerException.class, () -> stringJoiner.create(arguments));
    }

    @Test
    void shouldThrowExceptionWhenInputListIsEmpty() {
        // given
        StringJoiner stringJoiner = new StringJoiner();
        List<String> arguments = Collections.emptyList();

        // when && then
        assertThrows(IllegalArgumentException.class, () -> stringJoiner.create(arguments));
    }

    @Test
    void shouldJoinArgumentsFromList() {
        // given
        StringJoiner stringJoiner = new StringJoiner();
        List<String> arguments = Arrays.asList("a", "b", "c");
        String expectedResult = "abc";

        // when
        String result = stringJoiner.create(arguments);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldJoinArgumentsFromListAndNotThrowExceptions() {
        // given
        StringJoiner stringJoiner = new StringJoiner();
        List<String> arguments = Arrays.asList("a", "b", "c");

        // when && then
        assertDoesNotThrow(() -> stringJoiner.create(arguments));
    }

    // ugly example
    @Test
    void shouldJoinArgumentsFromListAndNotThrowExceptions2() {
        // given
        StringJoiner stringJoiner = new StringJoiner();
        List<String> arguments = Arrays.asList("a", "b", "c");

        // when && then
        try {
            stringJoiner.create(arguments);
        } catch (RuntimeException e) {
            Assertions.fail("Should not throw exception");
        }
    }
}