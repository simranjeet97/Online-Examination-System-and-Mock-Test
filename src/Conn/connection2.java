package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connection2 {  
    static String databasename="bug2db";
    static String url="jdbc:mysql://localhost:3306/";
    static String user="root";
    static String pass="root";
    
    public static Connection getConnection(String databasename)throws Exception {
     Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection(url+databasename,user,pass);
     return con;
 
    }
}