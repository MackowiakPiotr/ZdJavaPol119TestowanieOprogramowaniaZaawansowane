package pl.sdacademy.unit.test.advance.exercises.exceptions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorServiceTest {

    /*
    null, 123
    123, null
    null, null
     */

    @ParameterizedTest
    @MethodSource("dataProvider")
    void shouldThrowExceptionWhenANyOfArgumentIsNull(String a, String b) {
        //when & then
        //junit
//        assertThrows(IllegalArgumentException.class, () -> CalculatorService.add(a, b));

        //assertJ
        assertThatThrownBy(() -> CalculatorService.add(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Arguments 'a' and 'b' are required.");
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(null, "132"),
                Arguments.of("123", null),
                Arguments.of(null, null)
        );
    }
}