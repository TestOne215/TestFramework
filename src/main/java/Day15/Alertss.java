package Day15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Alertss {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.bookshopofindia.com/booknotfound.asp");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='btnSubmit']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.print(alert.getText());
        alert.accept();
        driver.findElement(By.name("Name")).sendKeys("Annie");
        driver.findElement(By.xpath("//input[@name='btnSubmit']")).click();
        System.out.print(alert.getText());
        alert.accept();
    }
}
