package pl.sdacademy.unit.test.advance.exercises.task4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/email_correctData.txt", delimiterString = ";")
    void shouldValidFileWithCorrectUserData(String input) {
        //given
        User user = getData(input);
        //when
        boolean result = user.valid();
        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/email_wrongNameData.txt", delimiterString = ";")
    void shouldValidFileWithInCorrectName(String input) {
        //given
        User user = getData(input);
        //when&then
        assertThatThrownBy(() -> user.valid())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("bad name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/email_wrongSurnameData.txt", delimiterString = ";")
    void shouldValidFileWithInCorrectSurname(String input) {
        //given
        User user = getData(input);
        //when&then
        assertThatThrownBy(() -> user.valid())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("bad surname");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/email_wrongEmailData.txt", delimiterString = ";")
    void shouldValidFileWithInCorrectEmail(String input) {
        //given
        User user = getData(input);
        //when&then
        assertThatThrownBy(() -> user.valid())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("bad email");
    }

    private User getData(String input) {
        String[] words = input.split(",");
        return new User(words[0], words[1], words[2]);
    }
}