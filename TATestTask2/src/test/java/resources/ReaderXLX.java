package resources;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReaderXLX extends ReaderFileData {
    public String[] value;
    public String[] action;
    public int iter;

    public String[] madeArrActions(String way) {
        File dataFile = null;
        HSSFWorkbook myExcelBook = null;

//        WayConstant.WAY_TO_DATA_FILE
        try {
            dataFile = new File(way);
            myExcelBook = new HSSFWorkbook(new FileInputStream(dataFile));
            HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

            HSSFCell celValue = null;
            HSSFRow rowValue = null;

            HSSFCell celAction = null;
            HSSFRow rowAction = null;
            for (int i = 0; i < 100; i++) {
                rowValue = myExcelSheet.getRow(i + 1);
                celValue = rowValue.getCell(1);
                if (celValue.toString().isEmpty()) {
                    iter = i;
                    break;
                }
            }

            value = new String[iter];
            action = new String[iter];

            for (int i = 0; i < value.length; i++) {
                rowValue = myExcelSheet.getRow(i + 1);
                celValue = rowValue.getCell(1);
                value[i] = celValue.toString();

                rowValue = myExcelSheet.getRow(i + 1);
                celValue = rowValue.getCell(0);
                action[i] = celValue.toString();
            }
            printArrays(value, action);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                myExcelBook.close();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
        return value;
    }
}
