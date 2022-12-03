package pl.sdacademy.unit.test.advance.examples.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RandomIntGeneratorTest {
    @Mock
    private RandomIntGenerator randomIntGenerator;

    @Test
    void shouldDemoHowWhenFromMockitoWorks() {
        Mockito.when(randomIntGenerator.generate()).thenReturn(5);
        int generatedValue = randomIntGenerator.generate();
        assertEquals(generatedValue, 5);
    }
}