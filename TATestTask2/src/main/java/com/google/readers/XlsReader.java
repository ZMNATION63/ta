package com.google.readers;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class XlsReader {
    protected static List<HolderActions> actions = new LinkedList<>();

    public List<String> value = new ArrayList<>();
    public List<String> action = new ArrayList<>();
    public int iterator = 0;
    private File dataFile;

    public File madeDataFile(String way) {
        File dataFile = new File(this.getClass().getResource(way).getFile());
        return dataFile;
    }

    public File getDataFile() {
        return dataFile;
    }

    public List<HolderActions> getActions() {
        return actions;
    }

    public void setActions(List<HolderActions> actions) {
        this.actions = actions;
    }

    public void setActionsAsEliments(HolderActions action) {
        this.actions.add(action);
    }

    public void setDataFile(File dataFile) {
        this.dataFile = dataFile;
    }

    public void arrActions(String way) {
        File dataFile = new File(way);//this.getClass().getResource(way).getFile()
        HolderActions holderActions = new HolderActions();

        try (FileInputStream file = new FileInputStream(dataFile)) {

            HSSFWorkbook myExcelBook = new HSSFWorkbook(file);
            HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

            Iterator<Row> rows = myExcelSheet.rowIterator();
            //пропускаем шапку табилцы
            if (rows.hasNext()) {
                rows.next();
            }
            int i = 0;
            String action = null;
            String xPath = null;

            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    action = cell.getStringCellValue();

                }
                setActionsAsEliments(new HolderActions(action, xPath));

            }
/*            int i = iterator;
            while (true) {
                rowValue = myExcelSheet.getRow(i + 1);
                celValue = rowValue.getCell(0);
                iterator++;
                i = iterator;
                if (celValue.toString().isEmpty()) {
                    //iterator++;
                    break;
                }
            }*/

//                System.out.println(iterator);

//                for (int j = 0; j < iterator - 1; j++) {
//                    rowValue = myExcelSheet.getRow(j + 1);
//                    celValue = rowValue.getCell(0);
//
//                    celAction = rowValue.getCell(1);
//
//                    System.out.println(celValue.toString());
//
//                    holderActions.setxPath(celValue.toString());
//
//                    setActionsAsEliments(new HolderActions((celValue.toString()), celAction.toString()));
//                }
            for (HolderActions a : actions) {
                System.out.println(a.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//        return value;
}

/**
 * public void arrActions(String way) {
 * //        File dataFile = new File(way);
 * File dataFile = new File(this.getClass().getResource("/dataFile.xls").getFile());
 * <p>
 * try(FileInputStream file = new FileInputStream(dataFile)) {
 * HSSFWorkbook myExcelBook = new HSSFWorkbook(file);
 * HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
 * <p>
 * HSSFCell celValue = null;
 * HSSFRow rowValue = null;
 * <p>
 * HSSFCell celAction = null;
 * HSSFRow rowAction = null;
 * for (int i = 0; i < 100; i++) {
 * rowValue = myExcelSheet.getRow(i + 1);
 * celValue = rowValue.getCell(1);
 * if (celValue.toString().isEmpty()) {
 * iterator = i;
 * break;
 * }
 * }
 * <p>
 * for (int i = 0; i < value.size(); i++) {
 * rowValue = myExcelSheet.getRow(i + 1);
 * celValue = rowValue.getCell(1);
 * this.value.add(celValue.toString());
 * <p>
 * rowValue = myExcelSheet.getRow(i + 1);
 * celValue = rowValue.getCell(0);
 * this.action.add(celValue.toString());
 * }
 * //            printArrays(value, action);
 * } catch (FileNotFoundException e) {
 * e.printStackTrace();
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * //        return value;
 */