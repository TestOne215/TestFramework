package Framework.TestScripts;
import Framework.Commons.Assertor;
import Framework.Commons.Logutil;
import Framework.Commons.ReportUtil;
import Framework.Constants.ApplicationConstants;


import Framework.DataProviders.Dp_Login;
import Framework.Commons.BaseTest;
import Framework.PageObjects.HomePage;
import Framework.PageObjects.SignInPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Framework.Constants.ApplicationConstants.*;
import java.io.IOException;

public class LoginTest extends BaseTest {
    @Test(enabled = false)
    public void validateInvalidLogin(){

        //launchApp("chrome");
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.name("logid")).sendKeys("qwertyu");
        driver.findElement(By.name("pswd")).sendKeys("ytrew");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
       if(driver.findElement(By.xpath("//b[contains(text(),'The username and/or password you entered is incorrect')]")).isDisplayed()){
           System.out.println("Pass");
       }
       else{
           System.out.println("fail");
       }

    }
//like to follow this appraoch-approach1
    @Test(dataProvider = "InvalidLoginData",dataProviderClass = Dp_Login.class)
    public void validateInvalidLogin_Approach1(String username,String password) throws IOException {
        Logutil.info("Testing the Invalid Login Scenerio");
        test=extentReports.createTest("Testing the Invalid Login Scenerio");//from base test,created for extent Reportss
        test.assignAuthor("Annie Mohan");
        test.assignDevice("iOS");
        test.assignCategory("Smoke");
        assertor = new Assertor(test);/**created object of the asserter because this
         assertor is a custom assertor that we have created
         which will take care of the pass and fail scenerio if the
        assetor passes or fails.And we pass test as the value to the constructor.*/
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInLink();
        Logutil.info("Currently in Home page");
        SignInPage signInPage = new SignInPage(driver);
        assertor.assertEquals(driver.getTitle(),"booksrediff.com","Sign in Page title is not matching#"+getScreenshot());
        Logutil.info("Currently in Sign In page");
        /**
         * this assertEquals is same as traditional assert
         * We are overriding only the pass and fails
         * Remaining things are taken from assert class only which Testng provides.
         */
        signInPage.enterUserCreddentials(username,password);
        /**
         * When you attach hash and get screenshot at the end of the assertor,
         * it means you are attaching a screenshot in the report even if pass or fail happens
         */
        assertor.assertTrue(signInPage.isinvalidErrorMessageDisplayed(),"Invalid Login error is not displayed#"+getScreenshot());
        /**
         * For every last line of @test you have assertor.assertAll()
         */
        assertor.assertAll();
    }

//    @Test
//    public void validateInvalidLogin_Approach2(){
//
//        // launchApp();
//        HomePage2 homePage = new HomePage2(driver);
//        SignInPage2 signInPage2 = homePage.clickSignInLink().enterUserCreddentials("annie", "1234");
//
//        if(signInPage2.isinvalidErrorMessageDisplayed()){
//            System.out.println("pass");
//        }else{
//            System.out.println("fail");
//        }
//
//
//    }

}
