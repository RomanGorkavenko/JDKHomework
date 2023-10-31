package ru.gb.jdk.homework.sem5.decision_second;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение №1.
 * Есть пять философов (потоки), которые могут либо
 * обедать (выполнение кода) либо размышлять
 * (ожидание).
 * Каждый философ должен пообедать три раза. Каждый
 * прием пищи длиться 500 миллисекунд
 * После каждого приема пищи философ должен
 * размышлять
 * Не должно возникнуть общей блокировки
 * Философы не должны есть больше одного раза подряд
 */
public class Main {
    private final static int PHILOSOPHER_COUNT = 5;

    public static void main(String[] args) {

        Routine routine = new Routine(new Lunch(), new Meditation(), new Lunch(), new Meditation(), new Lunch(), new Meditation());

        List<Philosopher> philosophers = new ArrayList<>();
        for (int j = 0; j < PHILOSOPHER_COUNT; j++) {
            philosophers.add(new Philosopher(routine));
        }
        for (Philosopher philosopher : philosophers) {
            new Thread(philosopher).start();
        }
    }
}
