package Day16;

import java.sql.*;

public class DBHandling {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
     try{
         //MYSQL DATABASE
         Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "S##48k@qirt");
         if(con!=null){
             System.out.println("Connection established "+con);
         }
         else{
             System.out.println("connection not established");
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
     }
     catch(Exception e){
           System.out.println("Exception is "+e.toString());
     }
     finally {
         if(con!=null && !con.isClosed()){
             System.out.println("connection is closed");
             con.close();
         }

     }

    }










}
