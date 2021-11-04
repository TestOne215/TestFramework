package Day13;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelRW {

    XSSFWorkbook wb;

    FileInputStream fis;
    //initialise an excel
//    public void initExcel(String xlPath) throws IOException {
//        //open the excel
//        fis = new FileInputStream(xlPath);
//        //connect the sheet
//         wb = new XSSFWorkbook(fis);
//    }

    public ExcelRW(String xlPath) throws IOException {
                //open the excel
       fis = new FileInputStream(xlPath);
        //connect the sheet
         wb = new XSSFWorkbook(fis);
    }
    public XSSFSheet getSheet(String sheetName){
        XSSFSheet sheet1 = wb.getSheet(sheetName);
        return sheet1;
    }

    //rowcount
public int getRowCount(String sheetName){
         //sheet1 = wb.getSheet(sheetName);
        return getSheet(sheetName).getLastRowNum();
}
    public int getColumnCount(String sheetName){
        //sheet1 = wb.getSheet(sheetName);
        return getSheet(sheetName).getRow(1).getLastCellNum();
    }


    //read operation
public String readCellValue(String sheetName,int row,int column){
    XSSFCell cell = getSheet(sheetName).getRow(row).getCell(column);
    String cellValue ="";
    if(cell.getCellType()== CellType.STRING){
        cellValue=cell.getStringCellValue();
    }
    else if(cell.getCellType()==CellType.NUMERIC){
        cellValue=String.valueOf(cell.getNumericCellValue());
    }
    else if(cell.getCellType()==CellType.BLANK){
        cellValue="";
    }
    return cellValue;

}


    //write operation
public void writeCellValue(String sheetName,int row, int column,String value){
    getSheet(sheetName).getRow(row).getCell(column).setCellValue(value);
}


    //save and close
public void saveAndCloseWorkbook(String xlPath) throws IOException {
    FileOutputStream fos = new FileOutputStream(xlPath);
    wb.write(fos);
    fis.close();
}

}
