package com.google.readers;

//Будет выполнять действия считанные из файлов
public class Action {
    public String action;
    public String xPath;
    public String description;

    public Action(String action, String xPath) {
        this.action = action;
        this.xPath = xPath;
        this.description = description;
    }

    public Action() {
    }

    @Override
    public String toString() {
        return "HolderActions{" +
                "action='" + action + '\'' +
                ", xPath='" + xPath + '\'' +
//                    ", Desc='" + description + '\'' +
                '}';
    }

}

