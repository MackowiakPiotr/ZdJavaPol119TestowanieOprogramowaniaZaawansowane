package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest2 {
    /*
    input, expectedResult
    0, 0
    1, 1
    4, 3
    7, 13
    12, 144
     */

    @ParameterizedTest
    @MethodSource("dataProvider")
    void shouldReturnCorrectValue(int input, int expectedResult) {
        //when
        int result = Fibonacci.getValueFromIndex(input);
        //then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(4, 3),
                Arguments.of(7, 13),
                Arguments.of(12, 144)
        );
    }

}