package pl.sdacademy.unit.test.advance.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.sdacademy.unit.test.advance.examples.parametrized.TemperatureConverter;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TemperatureConverterTest {

    @ParameterizedTest
    @EnumSource(TemperatureConverter.class)
    void shouldConvertToValueHigherThanMinInteger(TemperatureConverter converter) {
        assertTrue(converter.convertTemp(10) > Integer.MIN_VALUE);
    }

    @ParameterizedTest
    @EnumSource(
            value = TemperatureConverter.class,
            names = {"KELVIN_CELSIUS"},
            mode = EnumSource.Mode.EXCLUDE)
    void shouldConvertToTemperatureLowerThanMaxInteger(TemperatureConverter converter) {
        assertTrue(converter.convertTemp(10) < Integer.MAX_VALUE);
    }
}