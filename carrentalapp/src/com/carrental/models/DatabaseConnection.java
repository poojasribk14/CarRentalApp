package com.carrental.models;

import java.sql.*;

public class DatabaseConnection {
     
    public String url="jdbc:mysql://localhost:3306/appdb";
    public String user="root";
    public String pwd="Pooja@14";
    public String query="SELECT * FROM carrental";
    public void getDBConnection(){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
    try {
        con=DriverManager.getConnection(url,user,pwd);
        st=con.createStatement();
        rs= st.executeQuery(query);
        while(rs.next()){
            System.out.println("ID is :"+ rs.getInt(1));
        }
    }
    catch(SQLException e){
        e.printStackTrace();
    }

   
}
}
