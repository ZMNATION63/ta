package com.google.readers;

import java.io.File;
import java.util.List;

public abstract class AbstractReader {
    public int iter;
    public String way;
    List<Action> actions;
    private File dataFile;

    public abstract List<Action> arrActions(String way);

    public List<Action> getActions() {
        return actions;
    }

    public void printArrayT(List<Action> param) {
        for (Action k : param) {
            System.out.println(k);
        }
    }
}
