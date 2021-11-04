package Framework.Commons;

import Framework.Constants.ApplicationConstants.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.utils.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static Framework.Constants.ApplicationConstants.*;

public class BaseTest {
    public WebDriver driver;
    public static GlobalConfig config;
    public static ExtentReports extentReports;
    public ExtentTest test;
    public Assertor assertor;
    @BeforeSuite
    public void initSetup() {
        config = GlobalConfig.getProperties();
        extentReports = ReportUtil.getReport();
    }//creating object/accessing object from properties file
    @Parameters("browser")//browser is the parameter name
    @BeforeMethod
    public void launchApp(String browser) {

        switch (browser.toLowerCase()){
            case "firefox":
                    driver =getFirefoxDriver();
                    break;
            case "chrome":
                    driver = getChromeDriver();
                    break;
            case "ie":
                    driver=getInternetExplorerDriver();
                    break;
        }

        driver.get(config.get(config.get(CURRENT_ENVIRONMENT)));//accessing from application constants
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    /**
     * To get the firefox driver
     * @return
     */
    public WebDriver getFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);//accessing from application constants
        return new FirefoxDriver();

    }

    /**
     * To get the chrome driver
     * @return
     */
    public WebDriver getChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension",false);
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);//accessing from application constants
        return new ChromeDriver(options);

    }


    /**
     * To get the IE driver
     * @return
     */
    public WebDriver getInternetExplorerDriver(){
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);//accessing from application constants
        return new FirefoxDriver();

    }





    @AfterMethod
    public void tearDown() {

        extentReports.flush();
        driver.quit();
    }

    /**
     * to take screenshot
     * @return
     */

    public String getScreenshot() {
        String fileName=null;
        try {
            TakesScreenshot screen = (TakesScreenshot) driver;
            File img = screen.getScreenshotAs(OutputType.FILE);//stored in memory
            fileName = REPORT_PATH + "\\Screenshot\\screenshot_" + getUniqueDateTimeStamp() + ".png";
            FileHandler.copy(img, new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * to get unique date and timestamp
     * @return
     */
    public static String getUniqueDateTimeStamp() {
            Date date = new Date();
            System.out.println(date);
            SimpleDateFormat SimpleFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
            String cleanedDate = SimpleFormat.format(date);
            return cleanedDate;
        }


    @AfterSuite
    public void cleanProcess() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");


    }

    }
