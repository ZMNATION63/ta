package com.google.readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonReader extends AbstractReader {

//    public List<Action> getActions() {
//        return actions;
//    }
//
    @Override
    public void arrActions(String way) {
        Action holderActions = new Action();
        List<Action> action1 = null;
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
                if (action.isEmpty() != true) {
                    actions.add(new Action(action, xPath));
                }
            }
            printArrayT(actions);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
