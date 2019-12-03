package com.google;

import com.google.readers.ReaderTa;
import org.junit.Test;

//TODO Показать запуск из командной строки мейвеном тесты

//TODO найти класс java который рисует системонезависимый слеш - DONE
//TODO реализовать checkElementVisible, проверить в юнит тесте(2 штуки разных) положительный и отрицательный результат -DONE
//TODO Сделать второй тест с описание в json, реализовать парент класс для разных типов входных файлов и в зависимости от типа файла подкладывать реализацию чтения нужного формата. -DONE
//TODO Эксель должен парситься на экшены. Сделать тест номер два с придуманой последовательностью шагов, любые - DONE
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
    public void RunUiTest_UsingTest_TestPassedSuccessfully() {
        ReaderTa readerTa = new ReaderTa();
//        считвает все файлы в директории и берет их него данные для теста по очередно
        readerTa.runTestsFromPath(PathConstant.PATH_SEARCH_FILE);
//        ищет нужный формат файла и берет их него данные для теста
        readerTa.runTestsFromPath(PathConstant.PATH_SEARCH_FILE, "json");
        readerTa.runTestsFromPath(PathConstant.PATH_SEARCH_FILE, "xls");
    }
}






