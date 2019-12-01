package com.google.readers;

//Будет выполнять действия считанные из файлов
public class Action {
    public String action;
    public String xPath;
    public String Description;


    public Action(String action, String xPath) {
        this.action = action;
        this.xPath = xPath;
    }

    public Action() {
    }

    @Override
    public String toString() {
        return "HolderActions{" +
                "action='" + action + '\'' +
                ", xPath='" + xPath + '\'' +
                '}';
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getxPath() {
        return xPath;
    }

    public void setxPath(String xPath) {
        this.xPath = xPath;
    }


}
