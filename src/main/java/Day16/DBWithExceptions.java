package Day16;

import java.sql.*;

public class DBWithExceptions {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, myProjectException {
        Connection con=null;

         //MYSQL DATABASE
         Class.forName("com.mysql.cj.jdbc.Driver");
         try {
             con = DriverManager.getConnection("jdbc:mysql1://localhost:3306/myDB", "root", "S##48k@qirt");
         }catch(Exception e){
             System.out.println(e.toString());
         }
         if(con!=null){
             System.out.println("Connection established "+con);
         }
         else{
            throw new myProjectException("unable to connect.try again");
         }
         Statement stat = con.createStatement();
         ResultSet result = stat.executeQuery("select * from mydb.emp");

         ResultSetMetaData metaData = result.getMetaData();
         int columnCount = metaData.getColumnCount();


         while(result.next()){

             for(int iCol=1;iCol<=columnCount;iCol++){
                 String columnName = metaData.getColumnName(iCol);
                 String rowValue = result.getString(iCol);
                 System.out.println(columnName  +"<<<<<>>>>"  +rowValue);
             }
             //hardcoded value
//            System.out.println(result.getString("empid"));
//            System.out.println(result.getString("empName"));
         }
        con.close();

     }

    }











