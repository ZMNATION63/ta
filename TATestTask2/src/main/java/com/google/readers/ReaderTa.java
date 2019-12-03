package com.google.readers;

import com.google.PathConstant;
import com.google.script.ScriptManager;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ReaderTa {
    public List<Action> actions = new LinkedList<>();

    public void arrActions(String way) {
    }

    public List<Action> getActions() {
        return actions;
    }

    public void printArrayT(List<Action> param) {
        for (Action k : param) {
            System.out.println(k);
        }
    }

    //    определяет расширение файла
    private static String getFileExt(File file) {
        String fileName = file.getName();
        String result = "";
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            result = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return result;
    }

    public void runTestsFromPath(String path) {
        File myFolder = new File(PathConstant.PATH_SEARCH_FILE);
        File[] files = myFolder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() == true && getFileExt(files[i]).equals("json")) {
                ScriptManager scriptManager = new ScriptManager();
                scriptManager.runJson(files[i].getAbsolutePath());
            }
            if (files[i].isFile() == true && getFileExt(files[i]).equals("xls")) {
                ScriptManager scriptManager = new ScriptManager();
                scriptManager.runXlsTest(files[i].getAbsolutePath());
            }
        }
    }

    public void runTestsFromPath(String path, String priority) {
        File myFolder = new File(PathConstant.PATH_SEARCH_FILE);
        File[] files = myFolder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() == true && getFileExt(files[i]).equals("json") && priority.equals("json")) {
                ScriptManager scriptManager = new ScriptManager();
                scriptManager.runJson(files[i].getAbsolutePath());
            }
            if (files[i].isFile() == true && getFileExt(files[i]).equals("xls") && priority.equals("xls")) {
                ScriptManager scriptManager = new ScriptManager();
                scriptManager.runXlsTest(files[i].getAbsolutePath() );
            }
        }
    }
}
