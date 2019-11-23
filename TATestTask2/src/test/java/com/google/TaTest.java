package com.google;

import org.junit.Test;
import resources.ClickerChrome;
import resources.ReaderXLX;
import resources.WaysConstant;

//TODO Показать запуск из командной строки мейвеном тесты
//TODO не забудь выложить в гит лаб. Сделаешь раньше - присылай
//TODO Сделать второй тест с описание в json, реализовать парент класс для разных типов входных файлов и в зависимости от типа файла подкладывать реализацию чтения нужного формата.

//FIXME Сделать трайкетч с авторелизом ресурсов try with resources - DONE
//FIXME Имя тестового метода назвать правильно - DONE
//TODO реализовать checkElementVisible - DONE
//TODO в помнике явно указать на какой версии явы и какой синтакси ты используешь, надо 8ку - DONE
//TODO Работу с экселькой вынести в спомогательный класс - DONE
//TODO Эксель должен парситься на экшены, которые лежат в отдельных методах. - DONE
//FIXME  пернести в папку ресурсы и брать оттуда. - DONE
public class TaTest {

    @Test
    public void checkNcAvailable() {
        ReaderXLX readFile = new ReaderXLX();
        readFile.param = readFile.madeArrActions(WaysConstant.WAY_TO_DATA_FILE);
        ClickerChrome clickerChrome = new ClickerChrome();

//        readFile.printArgsArr(readFile.param); //печать массива
        clickerChrome.setBrowser();
        clickerChrome.openURL(readFile.param[0]);
        clickerChrome.clickByXPath(readFile.param[1]);
        clickerChrome.clickByXPath(readFile.param[2]," \\| ",2);
        clickerChrome.clickByXPath(readFile.param[4]);
        clickerChrome.takeScreenshot(WaysConstant.WAY_TO_SCREENSHOT);
        clickerChrome.closeChromeBrowser();
    }
}
/**
 *

 ReaderXLX readFile = new ReaderXLX();
 readFile.param = readFile.madeArrActions(WaysConstant.WAY_TO_DATA_FILE);
 readFile.printArgsArr(readFile.param);
 //      --------------------------------------------------
 System.setProperty(WaysConstant.TYPE_BROWSER_CHROME, WaysConstant.WAY_TO_CHROME_DRIVER);
 ChromeDriver chromeDriver = new ChromeDriver();
 //      открывает браузер
 chromeDriver.get(readFile.param[0]);
 //      кликает по поисковой строке
 WebElement element = (new WebDriverWait(chromeDriver, 3))
 .until(ExpectedConditions.presenceOfElementLocated(By.xpath(readFile.param[1])));
 //      разбивает строку запроса на запрос и клик
 String[] tempStr = readFile.param[2].split("\\| ", 2);
 element.sendKeys(tempStr[1]);
 //      забивает запрос в поисковую строку
 WebElement elementButton = (new WebDriverWait(chromeDriver, 3))
 .until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempStr[0])));

 //      кликает по кнопке поиска
 elementButton.submit();
 //      кликает на первое вхождение
 WebElement cli = chromeDriver.findElement(By.xpath(readFile.param[4]));
 cli.click();

 File scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
 FileUtils.copyFile(scrFile, new File(WaysConstant.WAY_TO_SCREENSHOT));
 //      закрывает браузер
 chromeDriver.quit();
 * */