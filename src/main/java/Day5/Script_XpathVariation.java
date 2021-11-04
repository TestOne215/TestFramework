package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Script_XpathVariation {
    public static void main(String[] args) {
        //launch application in firefox browser
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.unionbankofindia.co.in/english/emicalculator.aspx");


        //Enter loan amount
        driver.findElement(By.xpath("//table[@id='tblinput']//tr[2]/td/following-sibling::td[2]/input ")).sendKeys("200000");

        //Enter interest rate
        driver.findElement(By.xpath("//input[@name='rate' and @type='text']")).sendKeys("10");

        //enter period(tenure)
        driver.findElement(By.xpath("//input[@name='rate' and @type='text']/following::input[1]")).sendKeys("120");

        //click on calculate button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        //extract the value
        String output = driver.findElement(By.xpath("//input[@name='EMI' or @id='EMI1']")).getAttribute("value");
        System.out.println(output);






















    }
}
