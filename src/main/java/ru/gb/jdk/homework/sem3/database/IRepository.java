package ru.gb.jdk.homework.sem3.database;

import java.util.List;

public interface IRepository<T, Id> {
    int create(T item);
    int update(T item);
    int delete(Id id);
    T getById(Id id);
    List<T> getAll();
}
