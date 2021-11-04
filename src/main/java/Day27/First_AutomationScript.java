


package Day27;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class First_AutomationScript {
    public static void main(String[] args) {
//soft assert
        SoftAssert Assert = new SoftAssert();

        //launch application in firefox browser
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.unionbankofindia.co.in/english/emicalculator.aspx");

        if(driver.getTitle().equals("EMI Calculator")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        Assert.assertEquals(driver.getTitle(),"EM Calculator","Title is not matching");
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
        if(output.equals("234")){
            System.out.println("EMI Pass");
        }else{
            System.out.println("EMI Fail");
        }
        Assert.assertEquals(output,"234","EMI is not matching");
        driver.quit();
        Assert.assertAll();
       System.exit(0);//to exit from current thread
    }
}