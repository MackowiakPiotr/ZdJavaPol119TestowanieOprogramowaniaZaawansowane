package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.task1.provider.CalculatorProvider#provideDataForAdd")
    void shouldAddTwoValues(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = calculator.add(firstDigit, secondDigit);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.task1.provider.CalculatorProvider#provideDataForSubtract")
    void shouldSubtractTwoValues(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = calculator.subtract(firstDigit, secondDigit);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.task1.provider.CalculatorProvider#provideDataForMultiply")
    void shouldMultiplyTwoValues(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = calculator.multiply(firstDigit, secondDigit);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.task1.provider.CalculatorProvider#provideDataForDivide")
    void shouldDivideTwoValues(int firstDigit, int secondDigit, int expectedResult) {
        //when
        float result = calculator.divide(firstDigit, secondDigit);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldThrowExceptionWhenNumberIsGreaterThanDefaultValue() {
        //given
        int firstDigit = 5;
        int secondDigit = 0;
        //when & then
        //JUnit5
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(firstDigit, secondDigit),
                "Can't divide by 0");
        //AssertJ
        assertThatThrownBy(() -> calculator.divide(firstDigit, secondDigit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can't divide by 0");
    }
}