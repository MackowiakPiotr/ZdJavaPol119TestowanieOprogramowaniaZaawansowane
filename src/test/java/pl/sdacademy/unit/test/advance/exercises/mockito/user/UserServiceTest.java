package pl.sdacademy.unit.test.advance.exercises.mockito.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private static final User USER = new User(1L, "Jan", "Kowalski");
    private static final UserDto USER_DTO = new UserDto("Jan", "KOWALSKI");

    @Mock
    private UserRepository repository;

    @Mock
    private UserValidator validator;

    @InjectMocks
    private UserService service;

    @Test
    void shouldReturnUserById() {
        //given
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(USER));
        //when
        User result = service.getUserById(2L);
        //then
        assertThat(result).isEqualTo(USER);
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        //given
        Mockito.when(repository.findById(any())).thenReturn(Optional.empty());
        //when & then
        assertThatThrownBy(() -> service.getUserById(1L))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");
    }

    @Test
    void shouldCreateNewUser() {
        //given
        Mockito.when(validator.isUserValid(any())).thenReturn(true);
        Mockito.when(repository.addUser(any())).thenReturn(USER_DTO);
        //when
        UserDto result = service.createUser(USER);
        //then
        assertThat(result).isEqualTo(USER_DTO);
    }

    @Test
    void shouldThrowExceptionWhenUserIsNotValid() {
        //given
        Mockito.when(validator.isUserValid(any())).thenReturn(false);
        //when & then
        assertThatThrownBy(() -> service.createUser(USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User is invalid");
    }


}