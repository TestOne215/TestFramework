package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Script_CSSVariation {
    public static void main(String[] args) {
        //launch application in firefox browser
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.unionbankofindia.co.in/english/emicalculator.aspx");


        //Enter loan amount
        driver.findElement(By.cssSelector(" input[name='loanamount']")).sendKeys("200000");

        //Enter interest rate
        driver.findElement(By.cssSelector(" input[name='rate'][type='text']")).sendKeys("10");

        //enter period(tenure)
        driver.findElement(By.cssSelector(" table[id='tblinput']>tbody>tr:nth-of-type(4)>td:nth-of-type(3)>input")).sendKeys("120");
        //table#tblinput tr:nth-of-type(4) input
        //click on calculate button
        driver.findElement(By.cssSelector(" input[value='Calculate']")).click();

        //extract the value
        String output = driver.findElement(By.cssSelector("input[id='EMI'],[id='EMI1']")).getAttribute("value");
        System.out.println(output);
    }
}
