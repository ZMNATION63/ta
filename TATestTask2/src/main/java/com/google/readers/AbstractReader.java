package com.google.readers;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractReader {
    public List<Action> actions = new LinkedList<>();
    private File dataFile;

    public abstract void arrActions(String way);

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void printArrayT(List<Action> param) {
        for (Action k : param) {
            System.out.println(k);
        }
    }
}
