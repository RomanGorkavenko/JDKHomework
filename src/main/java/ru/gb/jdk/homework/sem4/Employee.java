package ru.gb.jdk.homework.sem4;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Задание 1. Создать справочник сотрудников
 * Необходимо:
 * ● Создать класс справочник сотрудников, который
 * содержит внутри коллекцию сотрудников - каждый
 * сотрудник должен иметь следующие атрибуты:
 * ○ Табельный номер
 * ○ Номер телефона
 * ○ Имя
 * ○ Стаж
 * ● Добавить метод, который ищет сотрудника по стажу
 * (может быть список)
 * ● Добавить метод, который выводит номер телефона
 * сотрудника по имени (может быть список)
 * ● Добавить метод, который ищет сотрудника по
 * табельному номеру
 * ● Добавить метод добавление нового сотрудника в
 * справочник
 */

public class Employee {

    private static int counter = 0;
    int id;
    private List<String> phone;
    private String name;
    private LocalDateTime hireDate;

    {
        id = ++counter;
    }

    public Employee(String name, LocalDateTime hireDate, String... phone) {
        this.phone = List.of(phone);
        this.name = name;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
