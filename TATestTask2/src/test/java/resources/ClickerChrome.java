package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class ClickerChrome {
    ChromeDriver browser;

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
        if (checkExistEl(tmpStr[0]) == true) {
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

    //разбивает строку на нужне количство частей и упаковывает их в массив строк
    //делает скрин
    public void takeScreenshot(String wayToSave) {
        File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(wayToSave));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean checkExistEl(String xPath) {
        boolean present;
        try {
            browser.findElement(By.xpath(xPath));
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
