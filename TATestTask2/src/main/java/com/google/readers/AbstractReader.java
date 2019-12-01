package com.google.readers;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractReader {
<<<<<<< HEAD
    public List<Action> actions = new LinkedList<>();
    private File dataFile;

    public abstract void arrActions(String way);
=======
    public int iter;
    public String way;
    List<Action> actions;
    private File dataFile;

    public abstract List<Action> arrActions(String way);
>>>>>>> aecd657d6bdc7a5674f0ddd6932c3438562d8d0e

    public List<Action> getActions() {
        return actions;
    }

<<<<<<< HEAD
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

=======
>>>>>>> aecd657d6bdc7a5674f0ddd6932c3438562d8d0e
    public void printArrayT(List<Action> param) {
        for (Action k : param) {
            System.out.println(k);
        }
    }
}
