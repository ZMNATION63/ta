package com.google.readers;
//Будет выполнять действия считанные из файлов
public class HolderActions {
    public String action;
    public String xPath;
    public String Description;


    public HolderActions(String action, String xPath) {
        this.action = action;
        this.xPath = xPath;
    }

    public HolderActions() {
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

    @Override
    public String toString() {
        return "HolderActions{" +
                "action='" + action + '\'' +
                ", xPath='" + xPath + '\'' +
                '}';
    }
}
