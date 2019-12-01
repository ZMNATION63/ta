package com.google.readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class JsonReader extends AbstractReader {
<<<<<<< HEAD

//    public List<Action> getActions() {
//        return actions;
//    }
//
    @Override
    public void arrActions(String way) {
        Action holderActions = new Action();
        List<Action> action1 = null;
=======
//    protected static List<HolderActions> actions = new ArrayList<>();
    private File dataFile;
    public String way;


    @Override
    public List<Action> arrActions(String way) {
        Action holderAction = new Action();
//        List<HolderActions> holderActions1 = null;
>>>>>>> aecd657d6bdc7a5674f0ddd6932c3438562d8d0e
        JSONParser parser = new JSONParser();
        JSONObject obj;
        try {
            obj = (JSONObject) parser.parse(new FileReader(getClass().getClassLoader().getResource(way).getFile()));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray from_excel = (JSONArray) jsonObject.get("from_excel");

//          вариант поименного вывода 3
            for (int i = 0; i < from_excel.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) from_excel.get(i);
                String action = (String) jsonObjectRow.get("Action");
                String xPath = (String) jsonObjectRow.get("Params");
                String descr = (String)jsonObjectRow.get("Description");
                if (action.isEmpty() != true) {
<<<<<<< HEAD
                    actions.add(new Action(action, xPath));
=======
                    holderAction = new Action(action, xPath, descr);
                    actions.add(holderAction);
>>>>>>> aecd657d6bdc7a5674f0ddd6932c3438562d8d0e
                }
            }
            printArrayT(actions);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
