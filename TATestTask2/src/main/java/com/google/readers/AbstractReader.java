package com.google.readers;

import java.util.Arrays;
import java.util.Formatter;

public abstract class AbstractReader {
    public String[] param;
    public String[] action;
    public int iter;
    public String way;

    /**
     *
//     * @param way
     * @return
     */
//    public abstract String[] madeArrActions(String way);

    public void printArgsArr(String[] param) {
        for (String k : param) {
            System.out.println(k);
        }
    }

    public void printArrays(String[] action, String[] value) {
        Formatter formatter = new Formatter();
        String act;
        String val;
        String s = "";
        for (int i = 0; i < value.length; i++) {
            act = action[i];
            val = value[i];

        }
//            System.out.printf("%-10s", action[i], value[i]);
        System.out.println(Arrays.toString(value));
        System.out.println(Arrays.toString(action));
    }

}
