package pl.sdacademy.unit.test.advance.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersUtilValueSourceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6, 8, 10, 100})
    void shouldReturnFalseIfDigitIsEven(int input) {
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 55})
    void shouldReturnTrueIfDigitIsOdd(int input) {
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertTrue(result);
    }
}