package kukulam.module.advancedtesting.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingTestExtension.class)
class NumberCalculatorTest2 {

    private NumberCalculator numberCalculator;

    @BeforeEach
    void setupEach() {
        this.numberCalculator = new NumberCalculatorImpl();
    }

    @AfterEach
    void cleanEach() {
        this.numberCalculator = null;
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