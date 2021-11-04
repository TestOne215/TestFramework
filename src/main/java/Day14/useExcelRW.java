package Day14;

import Day13.ExcelRW;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class useExcelRW {
    public static void main(String[] args) throws IOException, InterruptedException {

        ExcelRW excelRW = new ExcelRW("C:\\Training\\Search.xlsx");

        int rowCount = excelRW.getRowCount("sheet1");

        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.bing.com/");
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);





        for(int irow=1;irow<= rowCount;irow++) {
            String cellValue = excelRW.readCellValue("sheet1", irow, 0);
            driver.findElement(By.tagName("input")).sendKeys(cellValue);
            driver.findElement(By.id("search_icon")).click();


            String result = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
            excelRW.writeCellValue("sheet1",irow,1,result);

            //driver.navigate().to("https://www.bing.com/");
            //driver.navigate().back();

        }
        excelRW.saveAndCloseWorkbook("C:\\Training\\Search.xlsx");
        driver.quit();
    }
   
}
