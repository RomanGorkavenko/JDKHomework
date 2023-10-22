package ru.gb.jdk.homework.sem3.database;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository<Worker, Long> {
    @Override
    public int create(Worker item) {
        System.out.println("Added worker");
        return 1;
    }

    @Override
    public int update(Worker item) {
        System.out.println("Updated worker");
        return 1;
    }

    @Override
    public int delete(Long id) {
        System.out.println("Deleted worker");
        return 1;
    }

    @Override
    public Worker getById(Long id) {
        return new Worker();
    }

    @Override
    public List<Worker> getAll() {
        return new ArrayList<>(List.of(new Worker(), new Worker()));
    }
}
