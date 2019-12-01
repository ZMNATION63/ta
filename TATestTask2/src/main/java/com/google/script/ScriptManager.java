package com.google.script;

import com.google.WaysConstant;
import com.google.readers.Action;
import com.google.readers.JsonReader;
import com.google.readers.XlsReader;

import java.util.List;

public class ScriptManager {

    public void runXlsTest(){
        XlsReader xlsReader = new XlsReader();
        xlsReader.arrActions(WaysConstant.WAY_TO_DATA_XLS);

//        JsonReader jsonReader = new JsonReader();
//        jsonReader.arrActions(WaysConstant.WAY_TO_DATA_JSON);
        ClickChrome clickerChrome = new ClickChrome();
        List<Action> action = xlsReader.getActions();
        ScriptManager scriptManager = new ScriptManager();
        for (int i = 0; i < action.size(); i++) {
            scriptManager.scriptSwitch(action.get(i).action,action.get(i).xPath, clickerChrome);
        }
        clickerChrome.closeChromeBrowser();
    }

    public void runJson(){
        JsonReader jsonReader = new JsonReader();
        jsonReader.arrActions(WaysConstant.WAY_TO_DATA_JSON);
        ClickChrome clickerChrome = new ClickChrome();
        List<Action> action = jsonReader.getActions();
        ScriptManager scriptManager = new ScriptManager();
        for (int i = 0; i < action.size(); i++) {
            scriptManager.scriptSwitch(action.get(i).action,action.get(i).xPath, clickerChrome);
        }
        clickerChrome.closeChromeBrowser();
    }

    public void scriptSwitch(String action, String xPath, ClickChrome clickChrome) {
        /*
         * 1. openUrl
         * 2. click
         * 3. setValue + click
         * 4. screenshot
         * */
        switch (action) {
            case "openUrl":
                clickChrome.setBrowser();
                clickChrome.openURL(xPath);
                break;
            case "Click":
                clickChrome.clickByXPath(xPath);
                break;
            case "setValue":
                clickChrome.setValue(xPath);
                break;
            case "Screenshot":
                clickChrome.takeScreenshot(WaysConstant.WAY_TO_SCREENSHOT);
                break;
        }
    }
}
