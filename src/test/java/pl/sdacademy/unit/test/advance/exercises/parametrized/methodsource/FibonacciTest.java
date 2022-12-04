package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    /*
    input, expectedResult
    0, 0
    1, 1
    4, 3
    7, 13
    12, 144
     */

    @ParameterizedTest
    // cały package + '.' + nazwaKlasy + '#' + nazwaMetody
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider.FibonacciDataProvider#dataProvider")
    void shouldReturnCorrectValue(int input, int expectedResult) {
        //when
        int result = Fibonacci.getValueFromIndex(input);
        //then
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider.FibonacciDataProvider#dataProvider2")
    void test1(Account input, int expectedResult) {
        System.out.println(input);
    }
}