package ru.gb.jdk.homework.sem4;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
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

        NoteEmployee noteEmployee = new NoteEmployee();
        noteEmployee.add(new Employee("Bob", LocalDateTime.of(2020, Month.AUGUST, 5, 8, 0), "1234567"));
        noteEmployee.add(new Employee("Bob2", LocalDateTime.of(2018, Month.DECEMBER, 5, 8, 0), "12345676589"));
        noteEmployee.add(new Employee("Bob3", LocalDateTime.of(2013, Month.OCTOBER, 12, 8, 0), "12345676589"));
        noteEmployee.add(new Employee("Bob4", LocalDateTime.of(2022, Month.NOVEMBER, 7, 8, 0), "1234567888"));
        noteEmployee.add(new Employee("Bob5", LocalDateTime.of(2021, Month.JANUARY, 11, 8, 0), "123456"));
        noteEmployee.add(new Employee("John", LocalDateTime.of(2013, Month.APRIL, 5, 8, 0), "12345677", "000222333"));

        System.out.println(noteEmployee.getEmployeesByExperience(10));
        System.out.println(noteEmployee.getEmployeesPhoneNumberByName("John"));
        System.out.println(noteEmployee.getEmployeeById(6));
    }

}
