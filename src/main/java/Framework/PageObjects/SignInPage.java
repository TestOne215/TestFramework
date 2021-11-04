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
public class SignInPage extends PageObjectBase {

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
    public SignInPage(WebDriver driver){
        super(driver);  //calling constructor of PageObjectBase class //super is a class
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * The method enters username,password
     * @param userName
     * @param password
     */
    public void enterUserCreddentials(String userName, String password){
//    txt_emailID.sendKeys(userName);
//    txt_password.sendKeys(password);
//    btn_login.click();
        type(txt_emailID,userName);
        type(txt_password,password);
        click(btn_login);
}

    /**
     *
     * @return
     */
    public boolean isinvalidErrorMessageDisplayed(){

   // return lbl_errorMessage.isDisplayed();
        return isElementDisplayed(lbl_errorMessage);
}

}
