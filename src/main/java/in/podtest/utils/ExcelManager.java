package in.podtest.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelManager {

    String testDataFilePath = "src/test/resources/TestData.xlsx";
    File f1;
    FileInputStream fis;

    int rowCount;
    int colCount;

    public Object[][] readFile() throws IOException {
         f1 = new File(testDataFilePath);
         fis = new FileInputStream(f1);
         XSSFWorkbook wb = new XSSFWorkbook(fis);
         XSSFSheet sheet = wb.getSheetAt(0);

        rowCount = sheet.getLastRowNum();  //0 based
       // System.out.println("rowCount: "+rowCount);  //1

        colCount = sheet.getRow(0).getLastCellNum();
       // System.out.println("colCount: "+colCount);  //2

        Object[][] data = new Object[rowCount][colCount];

        String celldata;
        for(int i=1; i<rowCount+1; i++) {
            for(int j=0; j<colCount; j++) {

                celldata = sheet.getRow(i).getCell(j).toString();
               // System.out.println("data is: "+ celldata);
                data[i-1][j]=celldata;
            }
        }

       // System.out.println("--------------------------------------");

        for(int i=0; i<rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.println(data[i][j]);
            }
        }


        wb.close();
        fis.close();

        return data;

    }

}
