package com.google.readers;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XlsReader extends AbstractReader {

    public String[] value;
    public String[] action;
    public int iterator;

    public String[] madeArrActions(String way) {
        File dataFile = new File(way);

        try(FileInputStream file = new FileInputStream(dataFile)) {
            HSSFWorkbook myExcelBook = new HSSFWorkbook(file);
            HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

            HSSFCell celValue = null;
            HSSFRow rowValue = null;

            HSSFCell celAction = null;
            HSSFRow rowAction = null;
            for (int i = 0; i < 100; i++) {
                rowValue = myExcelSheet.getRow(i + 1);
                celValue = rowValue.getCell(1);
                if (celValue.toString().isEmpty()) {
                    iterator = i;
                    break;
                }
            }

            value = new String[iterator];
            action = new String[iterator];

            for (int i = 0; i < value.length; i++) {
                rowValue = myExcelSheet.getRow(i + 1);
                celValue = rowValue.getCell(1);
                value[i] = celValue.toString();

                rowValue = myExcelSheet.getRow(i + 1);
                celValue = rowValue.getCell(0);
                action[i] = celValue.toString();
            }
            printArrays(value, action);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
