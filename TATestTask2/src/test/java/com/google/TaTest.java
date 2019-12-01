package com.google;

import com.google.readers.Action;
<<<<<<< HEAD
import com.google.readers.XlsReader;
=======
import com.google.readers.JsonReader;
>>>>>>> aecd657d6bdc7a5674f0ddd6932c3438562d8d0e
import com.google.script.ClickChrome;
import com.google.script.ScriptManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.*;
import java.util.List;

<<<<<<< HEAD
//TODO Найти класс JAVA который рисует системонезависимые слеши
=======
//TODO найти класс java который рисует системонезависимый слеш
>>>>>>> aecd657d6bdc7a5674f0ddd6932c3438562d8d0e
//TODO Показать запуск из командной строки мейвеном тесты
//TODO Сделать второй тест с описание в json, реализовать парент класс для разных типов входных файлов и в зависимости от типа файла подкладывать реализацию чтения нужного формата.
//TODO реализовать checkElementVisible, проверить в юнит тесте(2 штуки разных) положительный и отрицательный результат
//TODO Эксель должен парситься на экшены. Сделать тест номер два с придуманой последовательностью шагов, любые

//TODO После запуска в папке со скринами должна создаться уникальная папка и все скрины (не перетирать один и тот же) класть в новую папку TESTRUN2019-01-10_13-15-47 - DONE
//TODO сделать два скрина в основном тесте, они просто должны быть разные - DONE
//FIXME пернести в папку ресурсы и брать оттуда. - DONE
//TODO не забудь выложить в гит лаб. Сделаешь раньше - присылай - DONE
//FIXME Сделать трайкетч с авторелизом ресурсов try with resources - DONE
//FIXME Имя тестового метода назвать правильно - DONE
//TODO в помнике явно указать на какой версии явы и какой синтакси ты используешь, надо 8ку - DONE
//TODO Работу с экселькой вынести в спомогательный класс - DONE

public class TaTest {
//    @Test
//    public void testFileCreation() throws IOException {
//        /**
//         * Date date1 = new Date();
//         *             SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
//         *             String datetime = formatForDateNow.format(date1);
//         *             wayForScreenshots = path + "\\" + datetime + "\\";
//         *             File file = new File(path);
//         *             file.mkdir();
//         */
//        Date date1 = new Date();
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
//        String datetime = formatForDateNow.format(date1);
//        File antonTxt = new File(new File("").getAbsolutePath() + WaysConstant.WAY_TO_SCREENSHOT + "\\" + "anton.txt");
////        new File(new File(".").getAbsolutePath() + WaysConstant.WAY_TO_SCREENSHOT, "anton.txt");
////        antonTxt.createNewFile();
////        System.out.println(new File(".").getAbsolutePath());
//    }

    @Test
<<<<<<< HEAD
    public void RunUiTest_UsingJsonTest_TestPassedSuccessfully() {
        ScriptManager scriptManager = new ScriptManager();
        scriptManager.runJson();
    }

    @Test
    public void RunUiTest_UsingExcelTest_TestPassedSuccessfully()  {
        ScriptManager scriptManager = new ScriptManager();
        scriptManager.runXlsTest();
=======
    public void RunUiTest_UsingExcelTest_TestPassedSuccessfully() throws IOException, InvalidFormatException, ParseException {
//        XlsReader xlsReader = new XlsReader();
//        xlsReader.arrActions(WaysConstant.WAY_TO_DATA_XLS);

        JsonReader jsonReader = new JsonReader();
        jsonReader.arrActions(WaysConstant.WAY_TO_DATA_JSON);
        ClickChrome clickerChrome = new ClickChrome();
//        clickerChrome.setBrowser();
        List<Action> actions = jsonReader.getActions(); //xlsReader.arrActions(WaysConstant.WAY_TO_DATA_XLS); //jsonReader.arrActions(WaysConstant.WAY_TO_DATA_JSON);
        ScriptManager scriptManager = new ScriptManager();
        for (int i = 0; i < actions.size(); i++) {
            scriptManager.scriptSwitch(actions.get(i).action, actions.get(i).xPath, clickerChrome);
        }
        clickerChrome.closeChromeBrowser();
>>>>>>> aecd657d6bdc7a5674f0ddd6932c3438562d8d0e
    }
}





