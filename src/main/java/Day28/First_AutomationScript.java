


package Day28;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;



public class First_AutomationScript {
    private static Logger log = Logger.getLogger(First_AutomationScript.class);
    public static void main(String[] args) {
        log.info("Started the Execution");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension",false);
        System.setProperty("webdriver.chrome.driver","C:\\Training\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        log.error("Started the Execution");
        //launch application in firefox browser
//        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
//        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.unionbankofindia.co.in/english/emicalculator.aspx");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        log.warn("taking too much time");

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

       // System.exit(0);//to exit from current thread
    }
}