package Framework.Commons;

import com.aventstack.extentreports.ExtentTest;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class Assertor extends SoftAssert {

    private ExtentTest test;

    public Assertor(ExtentTest test){
        this.test=test;
    }



    public void onAssertSuccess(IAssert<?> assertCommand){
        if(assertCommand.getMessage().contains("#")){
            Logutil.info(assertCommand.getMessage().split("#")[0]);
            ReportUtil.pass(test,assertCommand.getMessage().split("#")[0],assertCommand.getMessage().split("#")[1].trim()); //ex stores "Sign in Page title is not matching#"+getScreenshot()
        }else{
            Logutil.info(assertCommand.getMessage());
            ReportUtil.pass(test,assertCommand.getMessage());
        }
    }
  //  @override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex){//method overriding
        /**
         * AssertionError ex contains the entire string
         * mostly ex contains the message
         * but if hash and screenshot is there ,ex will contain the both
         */
        if(ex.getMessage().contains("#")){
            Logutil.error(ex.getMessage().split("#")[0]);
            ReportUtil.fail(test,ex.getMessage().split("#")[0],ex.getMessage().split("#")[1].split("expected")[0].trim()); //ex stores "Sign in Page title is not matching#"+getScreenshot()
        }else{
            Logutil.error(ex.getMessage());
            ReportUtil.fail(test,ex.getMessage());
        }
    }
}
