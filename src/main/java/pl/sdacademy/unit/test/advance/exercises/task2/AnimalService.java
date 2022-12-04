package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.concurrent.atomic.AtomicLong;

public class AnimalService {
    private AnimalRepository repository;
    private static AtomicLong idCounter = new AtomicLong();

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public Animal getById(long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("animal not exist with id: " + id));
    }

    public Animal add(String type, String name) {
        return repository.add(new Animal(idCounter.getAndIncrement(), type, name));
    }
}
