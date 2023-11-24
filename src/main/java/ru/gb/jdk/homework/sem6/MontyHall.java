package ru.gb.jdk.homework.sem6;

import one.util.streamex.EntryStream;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHall {
    public static void main(String[] args){

        Random random = new Random();
        int trial = 1000;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Игрок никогда не меняет свой выбор.");
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int participantDoor = random.nextInt(3);

            if (participantDoor == prizeDoor) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, 0);
            }
        }

        int win = EntryStream.of(hashMap).values().mapToInt(Integer::valueOf).sum();
        int count = EntryStream.of(hashMap).keys().mapToInt(Integer::valueOf).max().getAsInt();

        System.out.println("Верно угадано дверей из " + count + ": " + win);
        System.out.println("Процент верно угаданных дверей: " + df.format(((double) win / count) * 100) + " %");
        System.out.println();

        System.out.println("Игрок всегда меняет свой выбор.");
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int participantDoor = random.nextInt(3);

            int wrongDoor = prizeDoor;
            while (wrongDoor == prizeDoor ||
                    wrongDoor == participantDoor) {
                wrongDoor = random.nextInt(3);
            }

            int alternateDoor = 3 - (participantDoor + wrongDoor);

            if (alternateDoor == prizeDoor) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, 0);
            }
        }

        win = EntryStream.of(hashMap).values().mapToInt(Integer::valueOf).sum();
        count = EntryStream.of(hashMap).keys().mapToInt(Integer::valueOf).max().getAsInt();

        System.out.println("Верно угадано дверей из " + count + ": " + win);
        System.out.println("Процент верно угаданных дверей: " + df.format(((double) win / count) * 100) + " %");
    }
}
