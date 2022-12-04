package pl.sdacademy.unit.test.advance.exercises.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public int counterCharacters(File file) {
        int counter = 0;
        String extension = "";
        if (file != null && file.exists()) {
            String name = file.getName();
            extension = name.substring(name.lastIndexOf("."));
            if (!".csv".equalsIgnoreCase(extension)) {
                throw new IllegalArgumentException("wrong extension");
            }
        } else {
            throw new IllegalArgumentException("no found file");
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                counter += scanner.nextLine().length();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return counter;
    }
}