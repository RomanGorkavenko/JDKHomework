package ru.gb.jdk.homework.sem5.decision_second;

public class Lunch implements Action {
    @Override
    public void go(Philosopher philosopher) {
        try {
            Thread.sleep(500);
            System.out.println(philosopher.getName() + " по обедал");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
