package Day22;

import Day13.ExcelRW;
import org.testng.annotations.Test;

import java.util.Map;

public class TestScript {
//we have to mention the name of the dataprovider to use here and the class where the dataprovider resides.
    @Test(dataProvider="LoginData",dataProviderClass = dp.class,enabled = false)
    //for each test data we are passing 5 values so here we have to mention 5 values as well
    //order will be exactly same
    public void getdata(String a,String b, String c,String d, String e){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

    }

    @Test(dataProvider="LoginDataExcel",dataProviderClass = dp.class,enabled = false)
    public void getdata_Excel(Map<String,String> hm){//always map is used//string string is used to indicate key value pair
        System.out.println(hm.get("Name"));
        System.out.println(hm.get("City"));
        System.out.println(hm.get("State"));
        System.out.println(hm.get("Product"));
        System.out.println(hm.get("Country"));
        System.out.println("\n");

    }

    @Test(dataProvider="LoginDataHardcoded",dataProviderClass = dp.class)
    public void getdata_Hardcoded(Map<String,String> hm){//always map is used//string string is used to indicate key value pair
        System.out.println(hm.get("Name"));
        System.out.println(hm.get("City"));
        System.out.println(hm.get("State"));

        System.out.println("\n");

    }


}
