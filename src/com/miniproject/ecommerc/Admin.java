package com.miniproject.ecommerc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin { int a=0;
	PreparedStatement ps = null;
	Connection con = null ;
	
	public void loginAdmin() {
		
		
	}
	
	public void fetchCustomerDetails() {
	int	count = 1; 
		try {
			ConnectionTest test = new ConnectionTest();
		con=test.getConnection();
		ps = con.prepareStatement("select * from userdetails"); 
		ResultSet rs =ps.executeQuery();
		System.out.println("User List : \n");
		while (rs.next()) {
			
			System.out.println(count+".");
			
			System.out.println("Name : "+rs.getString(1));
			System.out.println("UserName :"+rs.getString(2));
			System.out.println("MobileNumber :"+rs.getLong(4));
			System.out.println("Address :"+rs.getString(5));
			count++;
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void productQuantity() {
		try {
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps = con.prepareStatement("select * from productlist"); 
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				
				System.out.println("Name :"+rs.getString(2));
				System.out.println("Quantity :"+rs.getInt(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
