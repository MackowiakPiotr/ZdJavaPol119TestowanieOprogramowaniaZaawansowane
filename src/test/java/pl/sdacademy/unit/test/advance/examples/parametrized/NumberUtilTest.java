package pl.sdacademy.unit.test.advance.examples.parametrized;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberUtilTest {

    @Test
    void shouldReturnFalseIfDigitIsEvenTest1() {
        //given
        int input = 0;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDigitIsEvenTest2() {
        //given
        int input = 2;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDigitIsEvenTest3() {
        //given
        int input = 4;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDigitIsEvenTest4() {
        //given
        int input = 6;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDigitIsEvenTest5() {
        //given
        int input = 8;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDigitIsEvenTest6() {
        //given
        int input = 10;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDigitIsEvenTest7() {
        //given
        int input = 100;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfDigitIsOddTest1() {
        //given
        int input = 1;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfDigitIsOddTest2() {
        //given
        int input = 3;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfDigitIsOddTest3() {
        //given
        int input = 5;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfDigitIsOddTest4() {
        //given
        int input = 7;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfDigitIsOddTest5() {
        //given
        int input = 9;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfDigitIsOddTest6() {
        //given
        int input = 55;
        //when
        boolean result = NumbersHelper.isOdd(input);
        //then
        assertTrue(result);
    }
}