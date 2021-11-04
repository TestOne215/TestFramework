


package Day18;
import Day17.Propertiefiles;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Screenshotss {
    public static void main(String[] args) throws IOException, InterruptedException {


        //implicit
        //explicit
        //fluent wait
        //Thread.sleep
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat SimpleFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
        String cleanedDate = SimpleFormat.format(date);
        System.out.println(cleanedDate);

        //launch application in firefox browser
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(Propertiefiles.getConfigValue(Propertiefiles.getConfigValue("env")));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);




        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\resources\\config.properties");
        prop.load(fis);
       //String url = prop.getProperty("QA");
        String url = prop.getProperty(prop.getProperty("env"));
        System.out.println(url);



        //Enter loan amount

        driver.findElement(By.id("loanamount")).sendKeys("200000");
        TakesScreenshot screen = (TakesScreenshot) driver;
        File img = screen.getScreenshotAs(OutputType.FILE);//stored in memory

        FileHandler.copy(img,new File(System.getProperty("user.dir")+"\\Screenshots\\screenshot_"+cleanedDate+".png"));
        //Enter interest rate
        driver.findElement(By.name("rate")).sendKeys("10");

        //enter period(tenure)
        driver.findElement(By.name("pmonths")).sendKeys("120");

        //click on calculate button
        driver.findElement(By.name("Button1")).click();

        //extract the value

       WebElement EMI=driver.findElement(By.id("EMI"));
        String output= EMI.getAttribute("value");
         date = new Date();
        System.out.println(date);
        cleanedDate = SimpleFormat.format(date);
        System.out.println(cleanedDate);
        img = screen.getScreenshotAs(OutputType.FILE);//stored in memory

                FileHandler.copy(img,new File(System.getProperty("user.dir")+"\\Screenshots\\screenshot_"+cleanedDate+".png"));
//        String output = driver.findElement(By.name("EMI")).getAttribute("value");
        System.out.println(output);

       // System.exit(0);//to exit from current thread
    }
}