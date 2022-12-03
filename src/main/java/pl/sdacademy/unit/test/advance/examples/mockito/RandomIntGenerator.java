package pl.sdacademy.unit.test.advance.examples.mockito;

import java.util.Random;

public class RandomIntGenerator {
    public int generate() {
        return new Random().nextInt();
    }
}