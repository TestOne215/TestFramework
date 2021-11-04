package Day13;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExcelReadandWrite {
    public static void main(String[] args) throws IOException, InterruptedException {


        //Open sheet 
        FileInputStream fis = new FileInputStream("C:\\Training\\Search.xlsx");
       
        //connect sheet
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheet("Sheet1");
        XSSFSheet sheet2 = wb.getSheet("Sheet2");

        //collect row count
        int rowCount = sheet1.getLastRowNum();

        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.bing.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);







        //logic-Reading from excel,Applying it to app,Extracting value and writing it back to excel
        for(int iRow=1;iRow<=rowCount;iRow++){

            //reading from a cell
            XSSFCell cell = sheet1.getRow(iRow).getCell(0);
            String cellValue ="";
            if(cell.getCellType()==CellType.STRING){
                cellValue=cell.getStringCellValue();
            }
            else if(cell.getCellType()==CellType.NUMERIC){
                cellValue=String.valueOf(cell.getNumericCellValue());
            }
           else if(cell.getCellType()==CellType.BLANK){
               cellValue="";
            }
           System.out.println(cellValue);
            driver.findElement(By.tagName("input")).sendKeys(cellValue);
            driver.findElement(By.id("search_icon")).click();
            String result = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/span[1]")).getText();
            System.out.println(result);
            sheet1.getRow(iRow).getCell(1).setCellValue(result);
            //back button
            driver.navigate().back();
//            FileOutputStream fos = new FileOutputStream("C:\\Training\\Search.xlsx");
//            wb.write(fos);
           //write to cell
           // sheet1.getRow(iRow).getCell(1).setCellValue("Hello");
        }

        //save the excel
       FileOutputStream fos = new FileOutputStream("C:\\Training\\Search.xlsx");
        wb.write(fos);


        //close the excel
        fis.close();
       // fos.close();
    }
}