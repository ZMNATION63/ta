package com.google.script;

import com.google.WaysConstant;
import com.google.readers.HolderActions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScriptManager {

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
