package ru.gb.jdk.homework.sem4;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

public class NoteEmployee {

    private final List<Employee> employees = new ArrayList<>();

    public boolean add(Employee employee) {
        if (employees != null && employee != null) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    public List<Employee> getEmployeesByExperience(int experience) {
        if (employees == null || employees.isEmpty()) {
            throw new RuntimeException("справочник сотрудников пуст");
        }
        List<Employee> result = new ArrayList<>();
        for (Employee employee: employees) {
            if ((LocalDateTime.now().getYear() - employee.getHireDate().getYear()) == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<String> getEmployeesPhoneNumberByName(String name) {
        if (employees == null || employees.isEmpty()) {
            throw new RuntimeException("справочник сотрудников пуст");
        }
        for (Employee employee: employees) {
            if (employee.getName().equals(name)) {
                return employee.getPhone();
            }
        }
        return null;
    }

    public Employee getEmployeeById(int id) {
        if (employees == null || employees.isEmpty()) {
            throw new RuntimeException("справочник сотрудников пуст");
        }

        for (Employee employee: employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
