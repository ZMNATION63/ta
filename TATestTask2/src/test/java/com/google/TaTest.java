package com.google;

import com.google.readers.XlsReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.google.WaysConstant.WAY_TO_DATA_FILE;

//TODO Показать запуск из командной строки мейвеном тесты
//TODO Сделать второй тест с описание в json, реализовать парент класс для разных типов входных файлов и в зависимости от типа файла подкладывать реализацию чтения нужного формата.
//TODO реализовать checkElementVisible, проверить в юнит тесте(2 штуки разных) положительный и отрицательный результат
//TODO После запуска в папке со скринами должна создаться уникальная папка и все скрины (не перетирать один и тот же) класть в новую папку TESTRUN2019-01-10_13-15-47
//TODO сделать два скрина в основном тесте, они просто должны быть разные
//FIXME пернести в папку ресурсы и брать оттуда.
//TODO Эксель должен парситься на экшены. Сделать тест номер два с придуманой последовательностью шагов, любые

//TODO не забудь выложить в гит лаб. Сделаешь раньше - присылай - DONE
//FIXME Сделать трайкетч с авторелизом ресурсов try with resources - DONE
//FIXME Имя тестового метода назвать правильно - DONE
//TODO в помнике явно указать на какой версии явы и какой синтакси ты используешь, надо 8ку - DONE
//TODO Работу с экселькой вынести в спомогательный класс - DONE

public class TaTest {

    @Test
    public void RunUiTest_UsingExcelTest_TestPassedSuccessfully() throws IOException, InvalidFormatException {
        /*FileInputStream fileInputStream = new FileInputStream(WaysConstant.WAY_TO_DATA_FILE);
        Workbook workbook = WorkbookFactory.create(fileInputStream);//classLoader.getResourceAsStream(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        sheet.forEach(row -> {
            String name = dataFormatter.formatCellValue(row.getCell(0));

            String interaction = dataFormatter.formatCellValue(row.getCell(1));

        });

        workbook.close();*/
        XlsReader readFile = new XlsReader();
        readFile.arrActions(WaysConstant.WAY_TO_DATA_FILE);

//        readFile.printArrays(readFile.action, readFile.value);
//        ClickerChrome clickerChrome = new ClickerChrome();
//        clickerChrome.setBrowser();
//        clickerChrome.openURL(readFile.value[0]);
//        clickerChrome.clickByXPath(readFile.value[1]);
//        clickerChrome.clickByXPath(readFile.value[2]," \\| ",2);
//        clickerChrome.clickByXPath(readFile.value[4]);
//        clickerChrome.takeScreenshot(WaysConstant.WAY_TO_SCREENSHOT);
//        clickerChrome.closeChromeBrowser();
    }
}
