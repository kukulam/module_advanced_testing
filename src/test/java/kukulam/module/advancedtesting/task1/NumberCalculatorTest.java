package kukulam.module.advancedtesting.task1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberCalculatorTest {

    private NumberCalculator numberCalculator;

    @BeforeEach
    void setupEach() {
        this.numberCalculator = new NumberCalculatorImpl();
    }

    @AfterEach
    void cleanEach() {
        this.numberCalculator = null;
    }

    @BeforeAll
    static void setupAll() {
        System.out.println("Starting tests for " + NumberCalculatorTest.class.toString());
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Ending tests for " + NumberCalculatorTest.class.toString());
    }

    @Test
    void shouldAddTwoNumbers() {
        // given
        int a = 1;
        int b = 2;
        int expectedResult = 3;

        // when
        int result = numberCalculator.add(a, b);

        // then
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("shouldMinusTwoNumbersNumbers")
    void shouldMinusTwoNumbers(int a, int b, int expectedResult) {
        // when
        int result = numberCalculator.minus(a, b);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> shouldMinusTwoNumbersNumbers() {
        return Stream.of(
                //                  a   b  expectedResult
                Arguments.arguments(10, 5, 5),
                Arguments.arguments(1, 2, -1),
                Arguments.arguments(2, 1, 1)
        );
    }

}