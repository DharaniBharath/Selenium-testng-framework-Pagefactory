package com.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

public class Utility {

    public static final int WAIT_TIME=10;
    public static final int PAGE_LOAD_TIME=60;


    public static String timeStamp() {

        Date date=new Date();
        String ts=date.toString().replace(' ','_').replace(':','_');
        return ts;
    }

    public static String timeStampnumber() {

        return new Date().getTime()+"";
    }


    public static Object[][] getDatafromExcelfile(String sheetName) {

        XSSFSheet sheet;
        XSSFWorkbook workbook = null;
        try {
            File file = new File("src/main/java/com/TestData/testdataframe.xlsx");
            FileInputStream Fin = new FileInputStream(file);
            workbook = new XSSFWorkbook(Fin);

        } catch (Exception e) {
            e.getStackTrace();
        }
        sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            for (int j = 0; j < cols; j++) {
                XSSFCell col = row.getCell(j);
                CellType cellType = col.getCellType();

                switch (cellType) {
                    case STRING:
                        data[i][j] = col.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = Integer.toString((int) col.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data[i][j] = col.getBooleanCellValue();
                        break;
                }

            }
        }
        return data;
    }
}
