package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider;

import org.junit.jupiter.params.provider.Arguments;
import pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.Account;

import java.util.stream.Stream;

public class FibonacciDataProvider {
    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(4, 3),
                Arguments.of(7, 13),
                Arguments.of(12, 144)
        );
    }

    public static Stream<Arguments> dataProvider2() {
        return Stream.of(
                Arguments.of(new Account(500, "123456"), 0),
                Arguments.of(new Account(1000, "123456"), 0)
        );
    }
}
