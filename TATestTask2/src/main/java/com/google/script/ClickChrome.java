package com.google.script;

import com.google.WaysConstant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClickChrome extends ScriptManager {
    private ChromeDriver browser;
    private final String wayForScreenshots;

    public ClickChrome() {
        Date date1 = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MM-yy_hh-mm-ss");
        String datetimeFolder = formatForDateNow.format(date1);
        wayForScreenshots = WaysConstant.WAY_TO_SCREENSHOT + "\\TESTRUN-" + datetimeFolder + "\\";

    }

    //      кликает на первое вхождение
    //открывает браузер - тест пройден
    public void setBrowser() {
        System.setProperty(WaysConstant.TYPE_BROWSER_CHROME, WaysConstant.WAY_TO_CHROME_DRIVER);
        this.browser = new ChromeDriver();
    }

    // открывает ссылку - тест пройден
    public void openURL(String url) {
        this.browser.get(url);
    }

    //  закрывает браузер - тест пройден
    public void closeChromeBrowser() {
        this.browser.quit();
    }

    //      разбивает строку запроса на запрос и кликает кнопку поиска
    public void clickByXPath(String xPath, String parsParam, int parts) {
        String[] tmpStr = madeRequestText(xPath, parsParam, parts);
        if (checkElementVisible(tmpStr[0]) == true) {
            //      забивает запрос в поисковую строку
            WebElement element = (new WebDriverWait(browser, 3))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(tmpStr[0])));
            element.sendKeys(tmpStr[1]);
            WebElement elementButton = (new WebDriverWait(browser, 3))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(tmpStr[0])));
            elementButton.submit();
        } else {
            System.out.println("Не могу выполнить задиние!!! Прверь метод" + getClass().getName());
        }
    }

    //      кликает на первое вхождение
    public void clickByXPath(String xPath) {
        WebElement cli = browser.findElement(By.xpath(xPath));
        cli.click();
    }

    void setValue(String xPath) {
        String[] tmpStr = madeRequestText(xPath, " \\| ", 2);
        if (checkElementVisible(tmpStr[0]) == true) {
            //      забивает запрос в поисковую строку
            WebElement element = (new WebDriverWait(browser, WaysConstant.TIME_OUT_IN_SEOND))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(tmpStr[0])));
            element.sendKeys(tmpStr[1]);
            WebElement elementButton = (new WebDriverWait(browser, WaysConstant.TIME_OUT_IN_SEOND))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(tmpStr[0])));
            elementButton.submit();
        } else {
            System.out.println("Не могу выполнить задиние!!! Прверь метод" + getClass().getName());
        }
    }

    //разбивает строку на нужне количство частей и упаковывает их в массив строк
    //делает скрин
    public void takeScreenshot(String path) {
        File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);

        try {
            File file = new File(wayForScreenshots);
            file.mkdir();
            Date dateForFileName = new Date();
            SimpleDateFormat formatForFileName = new SimpleDateFormat("hh-mm-ss");

            String screen = wayForScreenshots + "screen-" + formatForFileName.format(dateForFileName) + ".png";
            FileUtils.copyFile(scrFile, new File(screen));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean checkElementVisible(String xPath) {
        boolean present;
        try {
            browser.findElement(By.xpath(xPath)).isDisplayed();
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }

    String[] madeRequestText(String value, String parsParam, int parts) {
        String[] tempStr = value.split(parsParam, parts);
        return tempStr;
    }
}
