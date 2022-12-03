package pl.sdacademy.unit.test.advance.examples.exceptions;

public class ExceptionsExample {
    static int MAGIC_NUMBER = 5;

    public static String someMagicOperation(String text) {
        if (text.length() == MAGIC_NUMBER) {
            throw new IllegalArgumentException("String cannot have length equal 5");
        }
        return text.substring(0, 1).toUpperCase();
    }
}