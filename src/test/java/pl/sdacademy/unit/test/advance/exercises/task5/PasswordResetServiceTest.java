package pl.sdacademy.unit.test.advance.exercises.task5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordResetServiceTest {
    @Mock
    private RandomPasswordProvider passwordProvider;
    @Mock
    private DateTimeProvider dateTimeProvider;
    @InjectMocks
    private PasswordResetService service;

    @Test
    void shouldGenerateEmailBody() {
        //given
        when(passwordProvider.generateNewPassword()).thenReturn("admin1");
        when(dateTimeProvider.currentDateTime()).thenReturn(LocalDateTime.of(2000, 05, 25, 10, 12, 30));
        String expectedResult = "Twoje tymczasowe hasło wygenerowane dnia 2000-05-25 o godzinie 10:12:30 to admin1";
        //when
        String result = service.generateEmailBody();
        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}