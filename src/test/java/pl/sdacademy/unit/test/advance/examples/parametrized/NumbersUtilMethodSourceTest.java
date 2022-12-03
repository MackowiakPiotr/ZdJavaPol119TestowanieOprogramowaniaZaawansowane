package pl.sdacademy.unit.test.advance.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersUtilMethodSourceTest {

    @ParameterizedTest
    @MethodSource("provideEvenNumbers")
    void shouldReturnFalseIfDigitIsEven(int input) {
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    static Stream<Integer> provideEvenNumbers() {
        return Stream.of(0, 2, 4, 6, 8, 10, 100);
    }

    @ParameterizedTest
    @MethodSource("provideOddNumbers")
    void shouldReturnTrueIfDigitIsOdd(int input) {
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertTrue(result);
    }

    static Stream<Integer> provideOddNumbers() {
        return Stream.of(1, 3, 5, 7, 9, 55);
    }
}