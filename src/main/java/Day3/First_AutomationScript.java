


package Day3;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class First_AutomationScript {
    public static void main(String[] args) {


        //launch application in firefox browser
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.unionbankofindia.co.in/english/emicalculator.aspx");


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

       // System.exit(0);//to exit from current thread
    }
}