package com.google;

import com.google.readers.Action;
import com.google.readers.XlsReader;
import com.google.script.ClickChrome;
import com.google.script.ScriptManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.*;
import java.util.List;

//TODO Найти класс JAVA который рисует системонезависимые слеши
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

    @Test
    public void RunUiTest_UsingJsonTest_TestPassedSuccessfully() {
        ScriptManager scriptManager = new ScriptManager();
        scriptManager.runJson();
    }

    @Test
    public void RunUiTest_UsingExcelTest_TestPassedSuccessfully()  {
        ScriptManager scriptManager = new ScriptManager();
        scriptManager.runXlsTest();
    }
}





