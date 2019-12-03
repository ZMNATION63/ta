package com.google.script;

import com.google.PathConstant;

import com.google.readers.Action;
import com.google.readers.JsonReaderTa;
import com.google.readers.XlsReaderTa;

import java.util.List;

public class ScriptManager {

    public void runXlsTest(String path) {
        XlsReaderTa xlsReader = new XlsReaderTa();
        xlsReader.arrActions(path);

        ClickChrome clickerChrome = new ClickChrome();
        List<Action> action = xlsReader.getActions();
        ScriptManager scriptManager = new ScriptManager();
        for (int i = 0; i < action.size(); i++) {
            scriptManager.scriptSwitch(action.get(i).action, action.get(i).xPath, clickerChrome);
        }
        clickerChrome.closeChromeBrowser();
    }

    public void runJson(String path) {
        JsonReaderTa jsonReader = new JsonReaderTa();
        jsonReader.arrActions(path);
        ClickChrome clickerChrome = new ClickChrome();
        List<Action> action = jsonReader.getActions();
        ScriptManager scriptManager = new ScriptManager();
        for (int i = 0; i < action.size(); i++) {
            scriptManager.scriptSwitch(action.get(i).action, action.get(i).xPath, clickerChrome);
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
                clickChrome.takeScreenshot(PathConstant.PATH_TO_SCREENSHOT);
                break;
            case "checkElementVisible":
                clickChrome.checkElementVisible(xPath);
        }
    }
}
