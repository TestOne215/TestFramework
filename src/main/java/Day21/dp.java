package Day21;

import org.testng.annotations.DataProvider;

public class dp {

    //1.Object[][]
    //2.Iterator<Object[]>


    @DataProvider(name="LoginData")
    public static Object[][] dataprovider(){
        //Object[][] objects= new Object[3][2][1];
        //objects[0][0]="Annie"
        //objects[0][0]="1234"
        //objects[0][0]="John"
        //objects[0][0]="wernm"
        //objects[0][0]="Jim"
        //objects[0][0]="1234"
        return new Object[][]{
                {"Annie","1234"},
                {"John","wernm"},
                {"Jim","1234"}
        };
    }
}
