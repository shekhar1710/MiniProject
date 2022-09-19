package com.miniproject.ecommerce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BuyProduct {
	int sum=0;
	PreparedStatement prs =null;
	PreparedStatement ps = null;
	PreparedStatement ps7 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	Connection con = null ;
	static Scanner scan = new Scanner(System.in);
	
	static int lb;
	int longBook,scrapBook,pencilStripe,pencilMetallic,sharpnerBasic,sharpnerLong,eraser,crayons,pastels,ruler ;
	ShowProductList show = new ShowProductList();
	static List<Integer> list = new ArrayList<Integer>();
	static List<String> list2 = new ArrayList<>();
	static List<Integer> list3 = new ArrayList<>();
	static Map<String, Integer> map = new HashMap<String, Integer>();
 static int lbo,sc,pst,pm,sb,sl,ed,cr,pa,ru =1;
	public void processCart() throws SQLException {
		int a ;
		
		ConnectionTest test = new ConnectionTest();
		con=test.getConnection();
		ps3 = con.prepareStatement("update productlist set quantity = ? where productId=?;"); 
		ps2 = con.prepareStatement("select * from productlist"); 
		ResultSet sr =ps2.executeQuery();
		//lbo,sc,pst,pm,sb,sl,ed,cr,pa,ru
		while (sr.next()) {
			 if(1==sr.getInt(1)) {
			lbo= sr.getInt(5);
			
				}else if (2==sr.getInt(1)) {
					sc=sr.getInt(5);
				}
		}
		
		
		
		try {
		System.out.println("Please press a number to add product to cart :");
		a = scan.nextInt();
		System.out.println("Please enter the quantity less than upto 20:");
		
	if (a==1) {
		longBook=scan.nextInt();
		if(longBook<lbo && longBook>0) {
		list.add(60*longBook);
		list2.add("My long book 📔 -> Qty   ");
		list3.add(longBook);
		map.put("My long book 📔 -> Qty : "+longBook,60*longBook);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==2) {
		scrapBook=scan.nextInt();
		if(scrapBook<sc && scrapBook>0) {
		list.add(50*scrapBook);
		list2.add("My scrap book -> Qty    ");
		list3.add(scrapBook);
		map.put("My scrap book -> Qty "+ scrapBook,50*scrapBook);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==3) {
		pencilStripe=scan.nextInt();
		if(pencilStripe<21 && pencilStripe>0) {
		list.add(8*pencilStripe);
		list2.add("Fun pencil stripes -> Qty  ");
		list3.add(pencilStripe);
		map.put("Fun pencil stripes -> Qty "+pencilStripe,8*pencilStripe);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==4) {
		pencilMetallic=scan.nextInt();
		if(pencilMetallic<21 && pencilMetallic>0) {
		list.add(10*pencilMetallic);
		list2.add("Fun pencil metallic -> Qty");
		list3.add(pencilMetallic);
		map.put("Fun pencil metallic -> Qty "+pencilMetallic,10*pencilMetallic);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==5) {
		sharpnerBasic=scan.nextInt();
		if(sharpnerBasic<21 && sharpnerBasic>0) {
		list.add(10*sharpnerBasic);
		list2.add("Fun sharpners basic -> Qty");
		list3.add(sharpnerBasic);
		map.put("Fun sharpners basic -> Qty "+sharpnerBasic,10*sharpnerBasic);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==6) {
		sharpnerLong=scan.nextInt();
		if(sharpnerLong<21 && sharpnerLong>0) {
		list.add(12*sharpnerLong);
		list2.add("Fun sharpners long tip -> Qty");
		list3.add(sharpnerLong);
		map.put("Fun sharpners long tip -> Qty "+sharpnerLong,12*sharpnerLong);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==7) {
		eraser=scan.nextInt();
		if(eraser<21 && eraser>0) {
		list.add(8*eraser);
		list2.add("Fun dust free eraser -> Qty  ");
		list3.add(eraser);
		map.put("Fun dust free eraser -> Qty "+eraser,8*eraser);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==8) {
		crayons=scan.nextInt();
		if(crayons<21 && crayons>0) {
		list.add(40*crayons);
		list2.add("Fun crayons -> Qty    ");
		list3.add(crayons);
		map.put("Fun crayons -> Qty      "+crayons,40*crayons);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==9) {
		pastels=scan.nextInt();
		if(pastels<21 && pastels>0) {
		list.add(50*pastels);
		list2.add("Fun oil pastels -> Qty     ");
		list3.add(pastels);
		map.put("Fun oil pastels -> Qty    "+pastels,50*pastels);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		}else if (a==10) {
		ruler=scan.nextInt();
		if(ruler<21 && ruler>0) {
		list.add(20*ruler);
		list2.add("Fun ruler -> Qty      ");
		list3.add(ruler);
		map.put("Fun ruler -> Qty      "+ruler,20*ruler);
		}else {
			throw new InvalidInputException("please select quantity less than 20");
		}
		
	}else {
		throw new InvalidInputException("Invalid option selected");
	}
	con.close();
	ps3.close();
	ps2.close();
	sr.close();
		}catch(InvalidInputException e) {
		  System.out.println(e);
		  show.buyNow();
	  }
	try {
	System.out.println("Product added to the cart.");
	
	System.out.println("\nDo you want to continue shopping ? \nPress y to continue shopping\nPress any other key to go to payment");
	char b='y' ;
  b= scan.next().charAt(0);

  if(b=='y') {
	  show.buyNow();
	  
  }else {
	   for(int s : list) {
		   sum= sum+s;
		   }
	  
	//  Set<String> ks = map.keySet();
	  
	 Iterator<String> itr = list2.iterator();
	 Iterator<Integer> itr2 = list3.iterator();
	 Iterator<Integer> itr3 = list.iterator();
	 
	 
	 while(itr.hasNext()) {
		// String next = itr.next();
		 System.out.println(itr.next()+""+itr2.next()+"\t-"+itr3.next());
		// System.out.println(map.get(next));
		  }
	 System.out.println("----------------------------------------------------------------------------------------------------------------------");
	 System.out.println("Total payable amount is : Rs. "+sum);
	 String stringCheck = Register.user;
		String newAddress;
		boolean check = false;
		
		ConnectionTest test2 = new ConnectionTest();
		con=test2.getConnection();
		ps = con.prepareStatement("select * from userdetails"); 
		ResultSet rs =ps.executeQuery();
		Run run = new Run();
		
		while (rs.next()) {
			 check =stringCheck.equals(rs.getString(2));
			
			if(check==true) {
			System.out.println("Your registered address is : "+rs.getString(5));
			}
		}
		con.close();
		ps.close();
		rs.close();
		System.out.println("If you want to continue with same address : Press 1\nIf you want to add new Address : Press 2");
	char j = scan.next().charAt(0);
			if (j=='1') {
				
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("Total payable amount is : Rs. "+ sum);
				
				System.out.println(longBook);
				
				System.out.println("Payment method : Cash on Delivery");
				System.out.println("To confirm your order : Press 1\nTo cancel your order : Press any other key");
				char h=scan.next().charAt(0);
				if(h=='1') {
					System.out.println("Your order is confirmed.\nOrder will be delivered within 4-5 business days.\n\nThank You for shooping 😀.");
					
					ConnectionTest test3 = new ConnectionTest();
					con=test3.getConnection();
					ps4 = con.prepareStatement("update productlist set quantity = ? where productId=?;"); 
					ps6 = con.prepareStatement("update productlist set quantity = ? where productId=?;"); 
					ps5 = con.prepareStatement("select * from productlist");
					ps7= con.prepareStatement("select * from productlist");
					ResultSet sr2 =ps5.executeQuery();
					ResultSet sr3=ps7.executeQuery();
					lbo=lbo-longBook;
					while(sr2.next()) {
			            ps4.setInt(1,lbo);
						ps4.setInt(2,1);
						ps4.executeUpdate();
				    }
					
					run.first();
				}else {
					System.out.println("Order cancelled");
					run.first();
				}
				
			}else if (j=='2') {
				System.out.println("Please enter new address");
				newAddress= scan.nextLine();
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("Total payable amount is : Rs. "+sum);
				
				System.out.println("Delivery address : "+newAddress);
				System.out.println("Payment method : Cash on Delivery");
				System.out.println("To confirm your order : Press 1\nTo cancel your order : Press 2");
				char hp=scan.next().charAt(0);
				if(hp=='1') {
					System.out.println("Your order is confirmed.\nOrder will be delivered within 4-5 business days.\n\nThank You for shooping 😀.");
					
					//quantity query
					
					run.first();
				}else {
					run.first();
				}
			
			}else {
				throw new InvalidInputException("Invalid option selected.");
				
				
			}
			 
  }
  
  }catch(InvalidInputException e) {
	  System.out.println(e);
	  System.out.println("Please select the products again.");
	  show.buyNow();
  }
	}
}
  
	//public void payNow(int sum2) throws SQLException {
		
//		try {
//			String stringCheck = Register.user;
//			String newAddress;
//			boolean check = false;
//			ps = con.prepareStatement("select * from userdetails"); 
//			ResultSet rs =ps.executeQuery();
//			Run run = new Run();
//			
//			while (rs.next()) {
//				 check =stringCheck.equals(rs.getString(2));
//				
//				if(check==true) {
//				System.out.println("Your registered address is : "+rs.getString(5));
//				}
//			}
//			System.out.println("If you want to continue with same address : Press 1\nIf you want to add new Address : Press 2");
//		char j = scan.next().charAt(0);
//				if (j=='1') {
//					
//					System.out.println("-----------------------------------------------------------------------------------------------");
//					System.out.println("Total payable amount is : Rs. "+ sum2);
//					
//					System.out.println(longBook);
//					
//					System.out.println("Payment method : Cash on Delivery");
//					System.out.println("To confirm your order : Press 1\nTo cancel your order : Press any other key");
//					char h=scan.next().charAt(0);
//					if(h=='1') {
//						System.out.println("Your order is confirmed.\nOrder will be delivered within 4-5 business days.\n\nThank You for shooping 😀.");
//						
//						run.first();
//					}else {
//						System.out.println("Order cancelled");
//						run.first();
//					}
//					
//				}else if (j=='2') {
//					System.out.println("Please enter new address");
//					newAddress= scan.nextLine();
//					
//					
//					System.out.println("-----------------------------------------------------------------------------------------------");
//					System.out.println("Total payable amount is : Rs. "+sum2);
//					
//					System.out.println("Delivery address : "+newAddress);
//					System.out.println("Payment method : Cash on Delivery");
//					System.out.println("To confirm your order : Press 1\nTo cancel your order : Press 2");
//					char hp=scan.next().charAt(0);
//					if(hp=='1') {
//						System.out.println("Your order is confirmed.\nOrder will be delivered within 4-5 business days.\n\nThank You for shooping 😀.");
//						
//						run.first();
//					}else {
//						run.first();
//					}
//				
//				}else {
//					throw new InvalidInputException("Invalid option selected.");
//				}
//			
//			
//		} catch (InvalidInputException e) {
//			System.out.println(e);
//			pro.payNow(sum2);
//		}
//	scan.close();
//	}
//	
	
		
//}
	
	