package com.google.readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonReader extends AbstractReader {
    protected static List<HolderActions> actions = new ArrayList<>();
    private File dataFile;
    public String way;

    public static List<HolderActions> getActions() {
        return actions;
    }
//    @Override
    public List<HolderActions> arrActions(String way) {
        HolderActions holderActions = new HolderActions();
        List<HolderActions> holderActions1 = null;
        JSONParser parser = new JSONParser();
        JSONObject obj;
        try {
            obj = (JSONObject) parser.parse(new FileReader(getClass().getClassLoader().getResource(way).getFile()));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray from_excel = (JSONArray) jsonObject.get("from_excel");

//            // вариант поименного вывода 3
            for (int i = 0; i < from_excel.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) from_excel.get(i);
                String action = (String) jsonObjectRow.get("Action");
                String xPath = (String) jsonObjectRow.get("Params");
                if (action.isEmpty() != true) {
                    holderActions = new HolderActions(action, xPath);
                    actions.add(holderActions);
                }
            }
//            holderActions1 = new ArrayList<>(actions);
            printArrayT(actions);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }

        return actions;
    }
}
