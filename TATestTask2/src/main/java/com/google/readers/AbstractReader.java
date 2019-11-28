package com.google.readers;

import java.io.File;
import java.util.List;

public abstract class AbstractReader {
    public int iter;
    public String way;
    List<HolderActions> actions;
    private File dataFile;

//    public abstract void arrActions(String way);

    public void printArrayT(List<HolderActions> param) {
        for (HolderActions k : param) {
            System.out.println(k);
        }
    }
}
