package com.carrental.models;

import java.sql.*;

public class DatabaseConnection {
     
    public static String url="jdbc:mysql://localhost:3306/appdb";
    public static String user="root";
    public static String pwd="Pooja@14";
    public static String query="SELECT * FROM carrental";
    static Connection con=null;
        public static Connection getDBConnection(){
        try {
            con=DriverManager.getConnection(url,user,pwd);
    }
    catch(SQLException e){
        e.printStackTrace();
    }
    return con;
}
}
