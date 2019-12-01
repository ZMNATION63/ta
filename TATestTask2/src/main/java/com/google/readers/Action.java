package com.google.readers;

//Будет выполнять действия считанные из файлов
public class Action {
    public String action;
    public String xPath;
    public String  description;


<<<<<<< HEAD:TATestTask2/src/main/java/com/google/readers/Action.java
    public Action(String action, String xPath) {
=======
    public Action(String action, String xPath, String description) {
>>>>>>> aecd657d6bdc7a5674f0ddd6932c3438562d8d0e:TATestTask2/src/main/java/com/google/readers/HolderActions.java
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
                ", Desc='" + description + '\'' +
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
