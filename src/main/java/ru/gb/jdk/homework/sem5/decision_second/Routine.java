package ru.gb.jdk.homework.sem5.decision_second;

import java.util.ArrayList;
import java.util.Arrays;

public class Routine {

    private ArrayList<Action> actions;

    public Routine(Action... actions) {
        this.actions = new ArrayList<>(Arrays.asList(actions));
    }

    public ArrayList<Action> getActions() {
        return actions;
    }
}
