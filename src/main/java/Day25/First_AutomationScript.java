


package Day25;
import Framework.Constants.ApplicationConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class First_AutomationScript {
    public static void main(String[] args) throws IOException {

        //done only once
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\Report.html");
        ExtentLoggerReporter extentLoggerReporter = new ExtentLoggerReporter(System.getProperty("user.dir") + "\\Reports");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter,extentLoggerReporter);




        ExtentTest test = extentReports.createTest("Testing the EMI Calculation");
        test.assignAuthor("Annie Mohan");
        test.assignDevice("iOS");
        test.assignCategory("Smoke");


        test.info("Execution started");//going through pages
        //launch application in firefox browser
        System.setProperty("webdriver.gecko.driver", ApplicationConstants.GECKO_DRIVER_PATH);
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.unionbankofindia.co.in/english/emicalculator.aspx");
        test.pass("Successsfully launched the application");

        //where to find them
        //a.ID
        //b.Name
        //c.Class Name
        //d.TagName
        //e.LinkText
        //f.Partial LinkText
        //g.Xpath-Path of element in DOM
        //h.CSS- Path of element in DOM

        //Enter loan amount
        driver.findElement(By.id("loanamount")).sendKeys("200000");

        //Enter interest rate
        driver.findElement(By.name("rate")).sendKeys("10");

        //enter period(tenure)
        driver.findElement(By.name("pmonths")).sendKeys("120");

        //click on calculate button
        driver.findElement(By.name("Button1")).click();

        //extract the value
        String output = driver.findElement(By.name("EMI")).getAttribute("value");
        System.out.println(output);
        test.pass("Successsfully validated the EMI");
        TakesScreenshot screen = (TakesScreenshot) driver;
        File img = screen.getScreenshotAs(OutputType.FILE);//stored in memory

        FileHandler.copy(img,new File(System.getProperty("user.dir")+"\\Reports\\Screenshot\\screenshot.png"));
        test.fail("Failed validated the EMI", MediaEntityBuilder.createScreenCaptureFromPath("Screenshot\\screenshot.png").build());
       // System.exit(0);//to exit from current thread
        extentReports.flush();//saves what you have done so far,it is compulsory
    }
}