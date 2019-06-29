package indi.tony.autool.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelCommon {

    public static ArrayList<String> getRow(String excelPath, String sheetName, String columnOneValue){
        ArrayList<String> result = new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(excelPath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
            HSSFSheet sheet = workbook.getSheet(sheetName);
            int lastRowIndex = sheet.getLastRowNum();
            for (int i = 0; i <= lastRowIndex; i++) {
                HSSFRow row = sheet.getRow(i);
                if(row.getCell(0).getStringCellValue().equals(columnOneValue)){
                    int lastCellNum = row.getLastCellNum();
                    for (int j = 0; j < lastCellNum; j++) {
                        result.add(row.getCell(j).getStringCellValue());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
