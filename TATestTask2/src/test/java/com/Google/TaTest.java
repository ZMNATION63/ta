package com.Google;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class TaTest {
    @Test
    public void taTest() throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Projects\\TATest\\Server\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("http://www.google.com");

        WebElement myDynamicElement = (new WebDriverWait(chromeDriver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        WebElement element = chromeDriver.findElement(By.name("q"));
        element.sendKeys("netcracker.com");

        File scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\TAScreens\\EnterRequest.png"));
        element.submit();

        scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\TAScreens\\RequestResult.png"));


        WebElement cli = chromeDriver.findElement(By.className("TbwUpd"));
        cli.click();

        scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\TAScreens\\Result.png"));
    }
}
