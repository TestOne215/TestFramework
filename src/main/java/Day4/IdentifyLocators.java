package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IdentifyLocators {
    public static void main(String[] args) {
        //launch application in firefox browser
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
       // System.setProperty("webdriver.chrome.driver","C:\\Training\\Drivers\\chromedriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
       // ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/");

        driver.findElement(By.className("sb_form_q")).sendKeys("selenium");
        driver.findElement(By.id("search_icon")).click();

    }
}
