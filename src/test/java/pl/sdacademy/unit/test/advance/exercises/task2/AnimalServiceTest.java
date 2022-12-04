package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    private final static long CAT_ID = 1L;
    private final static String CAT_TYPE = "cat";
    private final static String CAT_NAME = "Filemon";
    private final static Animal ANIMAL = new Animal(CAT_ID, CAT_TYPE, CAT_NAME);

    @Mock
    private AnimalRepository animalRepository;
    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldGetAnimalById() {
        //given
        when(animalRepository.findById(anyLong())).thenReturn(Optional.of(ANIMAL));
        //when
        Animal result = animalService.getById(CAT_ID);
        //then
        assertThat(result).isEqualTo(ANIMAL);
        verify(animalRepository).findById(CAT_ID);
    }

    @Test
    void shouldCreateAnimal() {
        //given
        when(animalRepository.add(any())).thenReturn(ANIMAL);
        //when
        Animal result = animalService.add(CAT_TYPE, CAT_NAME);
        //then
        assertThat(result).isEqualTo(ANIMAL);
    }

    @Test
    void shouldThrowWhenAnimalDoesNotExist() {
        //given
        long notExistingAnimalId = CAT_ID + 1;
        when(animalRepository.findById(notExistingAnimalId)).thenReturn(Optional.empty());
        //when&then
        assertThatThrownBy(
                () -> animalService.getById(notExistingAnimalId))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("animal not exist with id: " + notExistingAnimalId);
        verifyNoMoreInteractions(animalRepository);
    }
}