package com.google.readers;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class XlsReader extends AbstractReader {
    protected static List<HolderActions> actions = new LinkedList<>();
    private File dataFile;
    public String way;

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

    public void printActionsArray(List<HolderActions> actions) {
        for (HolderActions a : actions) {
            System.out.println(a.toString());
        }
    }

    public List<HolderActions> arrActions(String way) {
//        HolderActions holderActions = new HolderActions();
//        List<HolderActions> holderActions1 = null;

        ClassLoader classLoader = getClass().getClassLoader();
        dataFile = new File(classLoader.getResource(way).getFile());
//        HolderActions holderActions = new HolderActions();

        try (FileInputStream file = new FileInputStream(dataFile)) {
            Workbook workbook = WorkbookFactory.create(file);

            // Getting the Sheet at index zero
            Sheet sheet = workbook.getSheetAt(0);

            // Create a DataFormatter to format and get each cell's value as String
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Row> rowIterator = sheet.rowIterator();

            //row - строка
            //cell - ячейка в строке
            while (rowIterator.hasNext()) {
                 Row row = rowIterator.next();

                // Now let's iterate over the columns of the current row
                Iterator<Cell> cellIterator = row.cellIterator();
                int i = 0;
                String action = null;
                String xPath = null;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (i == 0) {
                        action = dataFormatter.formatCellValue(cell);
                    }
                    if (i == 1) {
                        xPath = dataFormatter.formatCellValue(cell);
                        HolderActions actionFromXls = new HolderActions(action, xPath);
                        actions.add(actionFromXls);
                    }
                    i++;
                }
            }
            //printArrayT(actions);
//            holderActions1.addAll(actions);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (InvalidFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return actions;
    }
}

