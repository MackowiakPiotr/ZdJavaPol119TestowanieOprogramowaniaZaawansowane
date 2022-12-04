package pl.sdacademy.unit.test.advance.exercises.task3;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FileReaderTest {
    private static final String PATH = "src/test/resources/";
    FileReader fileReader = new FileReader();

    @Test
    void shouldCountCharactersAsExpected() {
        //given
        int expectedResult = 12;
        //when
        int result = fileReader.counterCharacters(new File(PATH + "file.csv"));
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldThrowWhenFileDoesNotExist() {
        assertThatThrownBy(() -> fileReader.counterCharacters(new File(PATH + "randomFile.csv")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("no found file");
    }

    @Test
    void shouldThrowWhenFileHasWrongExtension() {
        assertThatThrownBy(() -> fileReader.counterCharacters(new File(PATH + "file.txt")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("wrong extension");
    }
}