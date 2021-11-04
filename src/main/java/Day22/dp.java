package Day22;

import Day13.ExcelRW;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.*;

public class dp  {

    //1.Object[][]
    //2.Iterator<Object[]>

//Here name of the dataprovider is LoginData

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
                {"Annie","1234","Hi", "DataProviders","Tata"},//testdata
                {"John","wernm","Hi", "DataProviders","Tata"},
                {"Jim","1234","Hi", "DataProviders","Tata"}
        };
    }

    @DataProvider(name="LoginDataExcel")
    public static Iterator<Object[]> dataprovider_Excel() throws IOException {
        //read values from each row of excel
        String sheetName="sheet1";
        ExcelRW excelRW = new ExcelRW(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.xlsx");

        int rowCount = excelRW.getRowCount(sheetName);
        int columnCount = excelRW.getColumnCount(sheetName);

        //create a index in list
        ArrayList<Object[]> list = new ArrayList<Object[]>();//As nothing is mentioned it will accept any value
        for(int iRow=1;iRow<=rowCount;iRow++){
            Object[] obj = new Object[1];      //for each row an object array is created
            //in that object array,creat a map
            Map<String, String> map = new HashMap<>();//for each row a map is created
            for(int iCol=0;iCol<columnCount;iCol++){

                String key = excelRW.readCellValue(sheetName, 0, iCol);
                String value = excelRW.readCellValue(sheetName, iRow, iCol);
                //in that map,add all the values from the row as key value pair
                map.put(key,value);
            }//after for int icol loop the map is ready
            //now map should be added to object array
            obj[0]=map;
            //now add this to the list
            //in that location i should add a new object array
            list.add(obj);//obj is the array
        }
        //repeat this for all rows
return list.iterator();//?

    }

    //follow this approach as we dont use excel to extract values, we use hardcoded values
    @DataProvider(name="LoginDataHardcoded")
    public static Iterator<Object[]> dataprovider_hardcoded() throws IOException {
      return  Arrays.asList(new Object[]{//create array as list
             new HashMap<String,String>(){{
                 put("Name","John");
                 put("City","CA");
                 put("State","New York");
             }}
         },new Object[]{//create array as list
            new HashMap<String,String>(){{
                put("Name","Rajeesh");
                        put("City","Bangalore");
                        put("State","California");

    }}}).iterator();




}
}