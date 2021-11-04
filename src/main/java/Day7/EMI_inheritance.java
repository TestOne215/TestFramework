package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EMI_inheritance extends Base_inheritance{




        //Enter and extract
        String extractEmi(String amount,String interest,String tenure){
            //Enter loan amount
            driver.findElement(By.id("loanamount")).sendKeys(amount);

            //Enter interest rate
            driver.findElement(By.name("rate")).sendKeys(interest);

            //enter period(tenure)
            driver.findElement(By.name("pmonths")).sendKeys(tenure);

            //click on calculate button
            driver.findElement(By.name("Button1")).click();

            //extract the value
            String output = driver.findElement(By.name("EMI")).getAttribute("value");
            return output;
        }
        //Tear down
        void tearDown(){
           driver.quit();
        }







        // System.exit(0);//to exit from current thread

}
