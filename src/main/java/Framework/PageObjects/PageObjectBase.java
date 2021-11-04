package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectBase {//base foundation for all page objects

    public static final int DEFAULT_TIMEOUT=10;//constant value will not change,inorder to use final we have to use static




    WebDriver driver;
    public PageObjectBase(WebDriver driver){
        this.driver=driver;
    }

    public void click(WebElement element,int timeout){
        getWait(timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
        //element.click();
    }


    public void click(WebElement element){
        click(element,DEFAULT_TIMEOUT);
        //getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
        //element.click();
    }

    //enter the values
    public void type(WebElement element,String text){
        getWait().until(ExpectedConditions.elementToBeClickable(element)).clear();
        element.sendKeys(text);
       // element.sendKeys(text);
    }

    public boolean isElementDisplayed(WebElement element){
        try{
            getWait().until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
        }catch (Exception e){
            return false;
        }
         return true;
       // return element.isDisplayed();
    }

    public WebDriverWait getWait(){ //getwait internally calling another getwait
       return getWait(DEFAULT_TIMEOUT);
    }

    public WebDriverWait getWait(int timeout){
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }


}
