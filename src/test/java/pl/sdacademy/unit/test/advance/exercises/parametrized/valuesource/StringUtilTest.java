package pl.sdacademy.unit.test.advance.exercises.parametrized.valuesource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    /*
    true:
    null, "", " ", "      "

    false:
    "java", " java", "java ", " java "
     */

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void shouldReturnTrueIfStringIsBlank(String input) {
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"java", "  java", "java   ", " java "})
    void shouldReturnFalseIfStringIsNotBlank(String input) {
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueIFStringIsNull() {
        //when
        boolean result = StringUtil.isBlank(null);
        //then
        assertTrue(result);
    }

}