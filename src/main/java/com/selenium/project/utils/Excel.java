package com.selenium.project.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Excel {
    private FileInputStream fIn;
    private FileOutputStream fOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellStyle;
    private Color color;
    private Map<String, Integer> columns = new HashMap<>();
    private String excelFilePath;
    public void setExcelFile(String excelPath, String sheetName){
        try {
            File f = new File(excelPath);
            if(!f.exists()){
                f.createNewFile();
                Log.info("File doesn't exist, so created!");
            }
            fIn = new FileInputStream(excelPath);
            wb = WorkbookFactory.create(fIn);
            sh = wb.getSheet(sheetName);
            if(sh == null){
                sh = wb.createSheet(sheetName);
            }
            sh.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
            this.excelFilePath = excelPath;
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }
    public String getCellData (int rowNum, int colNum){
        try {
            cell = sh.getRow(rowNum).getCell(colNum);
            String cellData = null;
            switch (cell.getCellType()){
                case STRING:
                    cellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    cellData = String.valueOf(cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    cellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    cellData = "";
                default:
                    cellData = cell.getStringCellValue();
            }
            return cellData;

        } catch (Exception e){
            Log.info(e.getMessage());
            return "";
        }
    }
    public String getCellData (String colName, int rowNum){
        return getCellData(rowNum, columns.get(colName));
    }
}
