package pl.sdacademy.unit.test.advance.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsHelperCsvSourceTest {
    @ParameterizedTest
    @CsvSource({"'  test  ',TEST", "tEst ,TEST", "'   Java',JAVA"})
    void shouldTrimAndUppercaseInput(String input, String expected) {
        //when
        String actualValue = StringsHelper.toUpperCase(input);
        //then
        assertThat(actualValue).isEqualTo(expected); //AssertJ
        assertEquals(expected, actualValue); //JUnit5
    }
}