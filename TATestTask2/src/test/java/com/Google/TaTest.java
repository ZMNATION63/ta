package com.Google;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class TaTest {

    @Test
    public void taTest() throws InterruptedException, IOException {

        File dataFile = new File("D:\\TAScreens\\dataFile.xls");
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(dataFile));
        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        String[] param = new String[5];
        HSSFCell cell = null;
        HSSFRow row1 = null;

        for (int i = 0; i < param.length; i++) {
            row1 = myExcelSheet.getRow(i + 1);
            cell = row1.getCell(1);
            param[i] = cell.toString();
        }

        for (String k : param) {
            System.out.println(k);
        }

        myExcelBook.close();
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Projects\\TATest\\Server\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get(param[0]); //открываем сайт google

        WebElement element = (new WebDriverWait(chromeDriver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(param[1])));//дожидаемся пока строка поиска
                                                                                        //откроется
        String[] tempStr = param[2].split("\\| ", 2);
        element.sendKeys(tempStr[1]);

        WebElement elementButton = (new WebDriverWait(chromeDriver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempStr[0])));

        File scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\TAScreens\\EnterRequest.png"));

        elementButton.submit();

        scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\TAScreens\\RequestResult.png"));

        WebElement cli = chromeDriver.findElement(By.xpath(param[4]));
        cli.click();

        scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\TAScreens\\Result.png"));

        chromeDriver.quit();

    }
}
