package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.Objects;

public class Animal {
    private final long id;
    private final String type;
    private final String name;

    public Animal(long id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id && Objects.equals(type, animal.type) && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name);
    }
}
