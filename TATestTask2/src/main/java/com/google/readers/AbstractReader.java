package com.google.readers;

import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.util.List;

public abstract class AbstractReader {
    public int iter;
    public String way;
    List<HolderActions> actions;
    private File dataFile;

    public void printArgsArr(List<T> param) {
        for (T k : param) {
            System.out.println(k);
        }
    }
//
//    public void printArrays(String[] action, String[] value) {
//        Formatter formatter = new Formatter();
//        String act;
//        String val;
//        String s = "";
//        for (int i = 0; i < value.length; i++) {
//            act = action[i];
//            val = value[i];
//        }
//        System.out.println(Arrays.toString(value));
//        System.out.println(Arrays.toString(action));
//    }
}
