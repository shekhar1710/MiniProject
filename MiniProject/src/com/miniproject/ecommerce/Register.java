package com.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
	PreparedStatement ps = null;
	Connection con = null ;
	Scanner scanner = new Scanner(System.in);
	static String user ;
	String pass;
	String add;
	public void userLogin() throws InvalidInputException, SQLException {
		
		 boolean us=false;
		 boolean su=false;
		 ShowProductList show = new ShowProductList();
		BuyProduct pro =new BuyProduct();
		Register reg = new Register();
		Run run = new Run();
		try {
			
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps = con.prepareStatement("select * from userdetails"); 
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
				show.buyNow();
			
			}else {
				System.out.println("Invalid username or password");
				
				System.out.println("Press 1 : To login again");
				System.out.println("Press 2 : To register new user");
				System.out.println("Press any other key to exit");
				
				char k =scanner.next().charAt(0);
				if(k=='1') {
					reg.userLogin();
				}else if (k=='2') {
					reg.enterUser();
				}else{
					run.start();
				}
				
				
			}
				
			
		} catch (InvalidInputException e) {
			
			throw new InvalidInputException("Invalid input");
	
			
		}
	//	return user;
	}
	
	
	public void enterUser()throws InvalidInputException {
		UserInput us = new UserInput();
		Register tp = new Register();
		
CustomerDetails register = new CustomerDetails();
		
		try
		{
			System.out.print("Enter firstName => ");
			String firstName = scanner.nextLine();
			
			register.setFirstName(firstName);
			
			
			
			System.out.print("Enter userName => ");
			String userName = scanner.nextLine();
			
			register.setUserName(userName);
			
			
			System.out.print("Enter password => ");
			String password = scanner.nextLine();
			
			register.setPassword(password);
			
			
			System.out.print("Enter address => ");
			String address = scanner.nextLine();
			
			register.setAddress(address);
			
			
			System.out.print("Enter phoneNo => ");
			long phoneNo = scanner.nextLong();
			
			register.setPhoneNo(phoneNo);
			
			us.insertCustomerDetails(firstName,userName,password,phoneNo,address);
			
			System.out.println("Please login to continue.");
			tp.userLogin();
		}catch(Exception e) {
			throw new InvalidInputException(null);
		}
		
	}


	}
