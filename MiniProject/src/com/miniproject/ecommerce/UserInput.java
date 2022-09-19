package com.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInput {

	PreparedStatement ps = null;
	Connection con = null ;
		

	
	public void insertCustomerDetails(String Name, String Username, String Password, long MobileNumber, String Address) {
	
		try {
			
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			
			ps = con.prepareStatement("insert into userdetails(Name,Username,Password,MobileNumber,Address)values(?,?,?,?,?)");
			
			ps.setString(1 , Name);
			ps.setString(2 , Username );
			ps.setString(3 ,Password);
			ps.setLong(4 , MobileNumber );
			ps.setString(5 , Address);
		int i = ps.executeUpdate();	
		
		
		System.out.println("Registration Successful");
		
		con.close();
		ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
