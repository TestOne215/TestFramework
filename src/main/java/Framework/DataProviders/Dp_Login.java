package Framework.DataProviders;

import org.testng.annotations.DataProvider;

public class Dp_Login {

    @DataProvider(name="InvalidLoginData")
    public static Object[][] dataprovider(){
        //Object[][] objects= new Object[3][2][1];
        //objects[0][0]="Annie"
        //objects[0][0]="1234"
        //objects[0][0]="John"
        //objects[0][0]="wernm"
        //objects[0][0]="Jim"
        //objects[0][0]="1234"
        return new Object[][]{
                {"Annie","1234"},//testdata
                {"John","wernm"},
                {"Jim","1234"}
        };
    }









}
