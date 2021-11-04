


package Day18;
import Day17.Propertiefiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Threadsleep {
    public static void main(String[] args) throws IOException, InterruptedException {


        //implicit
        //explicit
        //fluent wait
        //Thread.sleep


        //launch application in firefox browser
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
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

        //Enter interest rate
        driver.findElement(By.name("rate")).sendKeys("10");

        //enter period(tenure)
        driver.findElement(By.name("pmonths")).sendKeys("120");

        //click on calculate button
        driver.findElement(By.name("Button1")).click();

        //extract the value
        Thread.sleep(10000);
       WebElement EMI=driver.findElement(By.id("EMI"));
        String output= EMI.getAttribute("value");
//        String output = driver.findElement(By.name("EMI")).getAttribute("value");
        System.out.println(output);

       // System.exit(0);//to exit from current thread
    }
}