package ru.gb.jdk.homework.sem5.decision_second;

public class Meditation implements Action {
    @Override
    public void go(Philosopher philosopher) {
        try {
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(philosopher.getName() + " по медитировал");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
