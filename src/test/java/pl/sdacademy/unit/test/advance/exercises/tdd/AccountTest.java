package pl.sdacademy.unit.test.advance.exercises.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    /*
    1. happy path
    2. accountNumber is wrong: 25 cyfr, 27 cyfr
    3. amount is wrong: amount > balance
     */

    @Test
    void shouldTransferMoney() {
        //given
        Account debit = new Account(1000, "11111111111111111111111111", new Customer("Jan", "Kowalski"));
        Account credit = new Account(5000, "11111111111111111111111111", new Customer("Jan", "Kowalski"));
        //when
        debit.transferMoney(credit, 500);
        //then
        assertEquals(500, debit.getBalance());
        assertEquals(5500, credit.getBalance());
    }

    @Test
    void shouldTransferMoneyWhenAmountIsEqualToZero() {
        //given
        Account debit = new Account(1000, "11111111111111111111111111", new Customer("Jan", "Kowalski"));
        Account credit = new Account(5000, "11111111111111111111111111", new Customer("Jan", "Kowalski"));
        //when
        debit.transferMoney(credit, 0);
        //then
        assertEquals(1000, debit.getBalance());
        assertEquals(5000, credit.getBalance());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111111111111111111111111", "111111111111111111111111111"})
    void shouldThrowExceptionWhenLengthDebitAccountIsWrong(String accountNumber) {
        //given
        Account debit = new Account(1000, accountNumber, new Customer("Jan", "Kowalski"));
        Account credit = new Account(5000, "11111111111111111111111111", new Customer("Jan", "Kowalski"));
        //when & then
        assertThatThrownBy(() -> debit.transferMoney(credit, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Account number has wrong length: " + accountNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2222222222222222222222222", "222222222222222222222222222"})
    void shouldThrowExceptionWhenLengthCreditAccountIsWrong(String accountNumber) {
        //given
        Account debit = new Account(1000, "11111111111111111111111111", new Customer("Jan", "Kowalski"));
        Account credit = new Account(5000, accountNumber, new Customer("Jan", "Kowalski"));
        //when & then
        assertThatThrownBy(() -> debit.transferMoney(credit, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Account number has wrong length: " + accountNumber);
    }

    @ParameterizedTest
    @ValueSource(floats = {1001, -1})
    void shouldThrowExceptionWhenAmountIsIncorrect(float amount) {
        //given
        Account debit = new Account(1000, "11111111111111111111111111", new Customer("Jan", "Kowalski"));
        Account credit = new Account(5000, "11111111111111111111111111", new Customer("Jan", "Kowalski"));
        //when & then
        assertThatThrownBy(() -> debit.transferMoney(credit, amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Amount is less than 0 or bigger than balance");
    }
}