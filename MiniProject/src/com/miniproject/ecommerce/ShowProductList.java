package com.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class ShowProductList {
	PreparedStatement ps = null;
	Connection con = null ;
	ConnectionTest test = new ConnectionTest();
	// Scanner scan1 = new Scanner(System.in);
	static int sum=0;
	
	public void processCart() throws SQLException {
		//Run run = new Run();
		Scanner scan1 = new Scanner(System.in);
		UserInput use = new UserInput();
		BuyProduct buy =new BuyProduct();
		ShowProductList show = new ShowProductList();
	try {
		System.out.println("Product added to the cart🛒.\n");
		System.out.println("\nDo you want to continue shopping ?\n \nTo continue shopping 🛍️: Press Y\nTo go to payment page 💰: Press any other key ");
	
	String  b= scan1.nextLine();;

	  if(b.equals("y")) {
		  buy.buyNow();  
	  }else {
		   for(int s : BuyProduct.list) {
			   sum= sum+s;
			   }
		  
		 Iterator<String> itr = BuyProduct.list2.iterator();
		 Iterator<Integer> itr2 = BuyProduct.list3.iterator();
		 Iterator<Integer> itr3 = BuyProduct.list.iterator();
		 
		  while(itr.hasNext()) {
			 System.out.println("\n"+itr.next()+""+itr2.next()+"\t= "+itr3.next());
			  }
		 System.out.println("----------------------------------------------------------------------------------------------------------------------");
		 System.out.println("-------------------------------------");
		 System.out.println("| Total payable amount is : Rs. "+sum +" |");
		 System.out.println("-------------------------------------");
		 String stringCheck = Register.user;
			String newAddress;
			boolean check = false;
			
			ConnectionTest test2 = new ConnectionTest();
			con=test2.getConnection();
			ps = con.prepareStatement("select * from userdetails"); 
			ResultSet rs =ps.executeQuery();
		
			
			while (rs.next()) {
				 check =stringCheck.equals(rs.getString(2));
				
				if(check==true) {
				System.out.println("\nYour registered address is : "+rs.getString(5));
				}
			}
			
		con.close();
		ps.close();
		rs.close();
			System.out.println("\n\nIf you want to continue with same address 🏠 : Press 1\nIf you want to add new Address 🏠: Press 2");
	
			String j = scan1.nextLine();
		
				if (j.equals("1")) {
					
					System.out.println("-----------------------------------------------------------------------------------------------\n");
					System.out.println("-------------------------------------");
					System.out.println("| Total payable amount is : Rs. "+ sum+" |");
					System.out.println("| Payment method : Cash on Delivery |");
					System.out.println("-------------------------------------");
					System.out.println("\nTo confirm your order : Press 1\nTo cancel your order and exit : Press any other key");
					String h=scan1.nextLine();
					if(h.equals("1")) {
						System.out.println("Your order is confirmed. ✔️\nOrder will be delivered within 4-5 business days. 🚚\n\n\nThank You for shooping 😀.");
						System.out.println(" Visit again 🙂...");
						show.quantitySubstraction();
						use.insertBuyHistory();
					}else {
						System.err.println("\nOrder cancelled");
						System.out.println("\n\n         Thank You 🙏🏻");
						System.out.println("         Visit again 🙂...");
						System.exit(0);;
					}
					
				}else if (j.equals("2")) {
					System.out.println("Please enter new address");
					newAddress= scan1.nextLine();
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("Total payable amount is : Rs. "+sum);
					
					System.out.println("Delivery address 🏠: "+newAddress);
					System.out.println("Payment method : Cash on Delivery\n\n");
					System.out.println("\nTo confirm your order : Press 1\nTo cancel your order and exit : Press any other key");
					
					String hp=scan1.nextLine();
					if(hp.equals("1")) {
						System.out.println("Your order is confirmed.\nOrder will be delivered within 4-5 business days.\n\n\n\nThank You for shooping 😀.");
						System.out.println(" Visit again 🙂...");
						show.quantitySubstraction();
						use.insertBuyHistory();
					}else {
						System.err.println("Order cancelled");
						System.out.println("\n\n       Thank You 🙏🏻");
						System.out.println("       Visit again 🙂...");
						System.exit(0);;
					}
				}else {
					throw new InvalidInputException("Invalid option selected.");	
				}		 
	  }
	  ;	
	  scan1.close();
	  }catch(InvalidInputException e) {
		  System.out.println(e);
		  System.out.println("Please select the products again.");
		  show.processCart();
	  }
		}

	public void quantitySubstraction( ) throws SQLException {
		
		int lbook,sbook,spencil,mpencil,bsharpner,lsharpner,deraser,fcrayons,fpastels,fruler ;
		
		PreparedStatement p =null;
		
		try {
				con=test.getConnection();
				ps = con.prepareStatement("Select * from productlist"); 
				p=con.prepareStatement("update productlist set quantity = ? where productId=?;");
			
				lbook=BuyProduct.lbo-BuyProduct.longBook;
			 p.setInt(1,lbook);
				p.setInt(2,1);
				p.executeUpdate();
	        	   
				sbook = BuyProduct.sc-BuyProduct.scrapBook;
				p.setInt(1,sbook);
				p.setInt(2,2);
				p.executeUpdate();
				
				spencil = BuyProduct.pst-BuyProduct.pencilStripe;
				p.setInt(1,spencil);
				p.setInt(2,3);
				p.executeUpdate();
				
				mpencil = BuyProduct.pm-BuyProduct.pencilMetallic;
				p.setInt(1,mpencil);
				p.setInt(2,4);
				p.executeUpdate();
				
				bsharpner = BuyProduct.sb-BuyProduct.sharpnerBasic;
				p.setInt(1,bsharpner);
				p.setInt(2,5);
				p.executeUpdate();
				
				lsharpner = BuyProduct.sl-BuyProduct.sharpnerLong;
				p.setInt(1,lsharpner);
				p.setInt(2,6);
				p.executeUpdate();
				
				deraser = BuyProduct.ed-BuyProduct.eraser;
				p.setInt(1,deraser);
				p.setInt(2,7);
				p.executeUpdate();
				
				fcrayons = BuyProduct.cr-BuyProduct.crayons;
				p.setInt(1,fcrayons);
				p.setInt(2,8);
				p.executeUpdate();
				
				fpastels = BuyProduct.pa-BuyProduct.pastels;
				p.setInt(1,fpastels);
				p.setInt(2,9);
				p.executeUpdate();
				
				fruler = BuyProduct.ru-BuyProduct.ruler;
				p.setInt(1,fruler);
				p.setInt(2,10);
				p.executeUpdate();
				con.close();
				ps.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
