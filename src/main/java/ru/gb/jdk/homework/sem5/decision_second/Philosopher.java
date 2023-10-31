package ru.gb.jdk.homework.sem5.decision_second;

public class Philosopher implements Runnable {

    private static int CURRENT;
    private final String name;

    private final Routine routine;

    static{
        CURRENT = 0;
    }
    public Philosopher(Routine routine) {
        this.routine = routine;
        CURRENT++;
        this.name = "Философ " + CURRENT;
    }

    @Override
    public void run() {
        for (int i = 0; i < routine.getActions().size(); i++) {
            routine.getActions().get(i).go(this);
        }
    }

    public String getName() {
        return name;
    }
}
