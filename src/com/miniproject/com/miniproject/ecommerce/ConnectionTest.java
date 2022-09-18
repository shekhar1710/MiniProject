package com.miniproject.ecommerce;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionTest {
        Connection con = null;
       
       public Connection getConnection() {
    	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection("jbbc:mysql://localhost:3306/jdbc","root","Pass@1987");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	   
    	   return con;
       }
}

}
