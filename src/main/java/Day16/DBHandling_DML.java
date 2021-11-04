package Day16;

import java.sql.*;

public class DBHandling_DML {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //MYSQL DATABASE
     Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "S##48k@qirt");
        if(con!=null){
            System.out.println("Connection established "+con);
        }
        else{
            System.out.println("connection not established");
        }
        Statement stat = con.createStatement();
       // ResultSet result = stat.executeQuery("select * from mydb.emp");
        stat.executeUpdate("update mydb.emp set empName='Ann' where empName='Annie'");

        con.close();
    }










}
