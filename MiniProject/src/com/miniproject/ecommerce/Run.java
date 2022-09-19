package com.miniproject.ecommerce;

import java.sql.SQLException;
import java.util.Scanner;

public class Run {
	static Scanner scanner = new Scanner(System.in);
	
	public void first() throws SQLException {
		Run run = new Run();
		
		System.out.println(" Welcome to Navneet stationary store ");
		System.out.println("For login : Press 1\nFor new user : Press 2\nAdmin login : Press 3");
		char u = scanner.next().charAt(0);
		Register re = new Register();
		Admin ad = new Admin();
		try {
		if(u=='1') {
			re.userLogin();
		}else if (u=='2') {
			re.enterUser();
		}else if (u=='3'){
			ad.loginAdmin();
		}else {
			
			throw new InvalidInputException("Please enter a valid number.");
			
		}
			
		}catch(InvalidInputException e) {
			System.out.println(e);
			run.call();
			
		}
		
		
	}
	
	public void call() throws SQLException {
		Run run = new Run();
		run.first();
	}
	
	public void start() throws InvalidInputException, SQLException {
		
		Register reg = new Register();
		try{
			reg.userLogin();
			}catch(InvalidInputException e) {
				
				System.out.println(e);
			}
	}
	
	public static void main(String[] args) throws InvalidInputException, SQLException {
		BuyProduct buy = new BuyProduct();
		Run run = new Run();
		run.call();
		
	int a =	buy.longBook;
		System.out.println(a);
//		Run run = new Run();
		
		
		
		
		
//		String a = "asa";
//		String b = "hjhjgh";
//		String c = "uuussss";
//		long d = 545446;
//		String e = "asa";
//		UserInput us = new UserInput();
//		run.start();
		//reg.enterUser();
		//reg.insertCustomerDetails(getfirstName,b,c,d,e);
		
		
		//ad.productQuantity();
		//ad.fetchCustomerDetails();
		
		BuyProduct by = new BuyProduct();
		//by.buyNow();
	}

}
