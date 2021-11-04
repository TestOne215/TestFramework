package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class handles the elemnts and business logics for SignIn Page
 *
 * @author Annie Mohan
 * @since 27-october-2021
 */
public class SignInPage2 {

    WebDriver driver;
    //For Login

    @FindBy(name="logid")
    private WebElement txt_emailID;

    @FindBy(name="pswd")
    private WebElement txt_password;

    @FindBy(xpath="//input[@value='Login']")
    private WebElement btn_login;

    //login
    @FindBy(xpath="//b[contains(text(),'The username and/or password you entered is incorrect')]")
    private WebElement lbl_errorMessage;

    /**
     *
     * @param driver
     */
    public SignInPage2(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * The method enters username,password
     * @param userName
     * @param password
     * @return
     */
    public SignInPage2 enterUserCreddentials(String userName, String password){
    txt_emailID.sendKeys(userName);
    txt_password.sendKeys(password);
    btn_login.click();
    return new SignInPage2(driver);
}

    /**
     *
     * @return
     */
    public boolean isinvalidErrorMessageDisplayed(){

    return lbl_errorMessage.isDisplayed();
}

}
