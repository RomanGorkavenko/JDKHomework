package ru.gb.jdk.homework.sem3.pair;

/**
 * 4. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
 * Класс должен иметь методы getFirst(),
 * getSecond() для
 * получения значений пары, а также
 * переопределение метода toString(), возвращающее строковое представление пары.
 *
 * Создайте интерфейс, который определяет набор методов для работы с базой данных
 * (например, сохранение, удаление, получение данных). Реализуйте этот интерфейс в конкретном классе.
 */
public class Main {

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("str", 123);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair);
    }

}
