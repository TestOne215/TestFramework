package Day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;

public class readDropdownvalues {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.carwale.com/used/cars-for-sale/#sc=-1&so=-1&pn=1");
        driver.findElement(By.xpath("//*[@id='closeLocIcon']")).click();
        List<WebElement> ele = driver.findElements(By.xpath("//select[@id='drpCity']/option"));
        Iterator<WebElement> iterator = ele.iterator();
        while(iterator.hasNext()){
            WebElement next = iterator.next();
            System.out.println(next.getText());
        }
    }
}
