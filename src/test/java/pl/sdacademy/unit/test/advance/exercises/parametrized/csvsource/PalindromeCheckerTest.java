package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeCheckerTest {
    /*
    true:
        kajak
        sedes
        kobyla ma maly bok

    false:
    java
    programowanie
     */

    @ParameterizedTest
    @CsvSource({
            "kajak, true",
            "sedes, true",
            "kobyla ma maly bok, true",
            "java, false",
            "programowanie, false"
    })
    void shouldVerifyStringIsPalindrome(String input, boolean expectedResult) {
        //given
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/palindrome.csv",
            numLinesToSkip = 5,
            delimiter = '|'
    )
    void shouldVerifyStringIsPalindrome_CsvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result);
    }

//    /*
//    Account
//        double saldo
//        String accountNumber
//     */
//
//    @ParameterizedTest
//    @CsvSource({
//            "1000, 12456, 500, true",
//            "30_000, 789456, 100_000, false",
//    })
//    void test(double saldo, String accountNumber, double amount, boolean expectedResult) {
//        //given
//        Account account = new Account(saldo, accountNumber);
//        //when
//        boolean result = account.wyslijPrzelew(amount);
//        //then
//        assertEquals(expectedResult, result);
//    }

}