package com.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
	PreparedStatement ps = null;
	Connection con = null ;
	Scanner scanner = new Scanner(System.in);
	

	
	
	
	public void loginAdmin() throws SQLException, InvalidInputException {
		String user;
		String pass;
		boolean us=false;
		 boolean su=false;
		Admin ad  = new Admin(); 
		Run run = new Run ();
		
		try {
			
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps = con.prepareStatement("select * from admindetails"); 
			ResultSet rs =ps.executeQuery();
			System.out.println("Please enter your username : ");
			user=scanner.nextLine();
			System.out.println("Please enter your password : ");
			pass=scanner.nextLine();
			while (rs.next()) {
				 us =user.equals(rs.getString(2));
				su = pass.equals(rs.getString(3));
				
			}
			if(us==true&&su==true) {
				System.out.println("Login successful\n");
				
				System.out.println("Press 1 for checking customer details\nPress 2 for checking product quantity remaining\nPress 3 to exit");
			char qq= scanner.next().charAt(0);
			if(qq=='1') {
				ad.fetchCustomerDetails();
			}else if (qq=='2'){
				ad.productQuantity();
			}else {
				run.first();
			}
				
			}else {
				throw new InvalidInputException("Invalid username or password");
				
				
				
			}
		} catch (InvalidInputException e) {
			System.out.println(e);
			
			System.out.println("Press 1 : To login again");
			System.out.println("Press any other key to exit");
			
			char k =scanner.next().charAt(0);
			if(k=='1') {
				ad.loginAdmin();
			}else{
				run.first();
			}
			
			
		}
			
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
