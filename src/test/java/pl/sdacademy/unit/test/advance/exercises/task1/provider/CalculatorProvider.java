package pl.sdacademy.unit.test.advance.exercises.task1.provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorProvider {
    static Stream<Arguments> provideDataForAdd() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 2),
                Arguments.of(-4, 3, -1),
                Arguments.of(-10, -8, -18),
                Arguments.of(5, -9, -4)
        );
    }

    static Stream<Arguments> provideDataForSubtract() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 0),
                Arguments.of(-4, 3, -7),
                Arguments.of(-10, -8, -2),
                Arguments.of(5, -9, 14)
        );
    }

    static Stream<Arguments> provideDataForMultiply() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(-4, 3, -12),
                Arguments.of(-10, -8, 80),
                Arguments.of(5, -9, -45)
        );
    }

    static Stream<Arguments> provideDataForDivide() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(10, 5, 2)
        );
    }
}