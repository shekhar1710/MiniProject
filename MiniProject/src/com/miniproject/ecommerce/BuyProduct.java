package com.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class BuyProduct {

	PreparedStatement ps = null;
	Connection con = null ;
	Scanner scan = new Scanner(System.in);
	static List<Integer> list = new ArrayList<Integer>();
	static Map<String, Integer> map = new HashMap<String, Integer>();
	static int longBook,scrapBook,pencilStripe,pencilMetallic,sharpnerBasic,sharpnerLong,eraser,crayons,pastels,ruler ;
	
	public void buyNow() {
		BuyProduct by = new BuyProduct();
		int count =1;
		 int x =0;
		
		try {
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps = con.prepareStatement("select * from productlist"); 
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Product Id :"+rs.getString(1));
				System.out.println("Product Name :"+rs.getString(2));
				System.out.println("Description :"+rs.getString(3));
				System.out.println("Price :Rs."+rs.getString(4));
				System.out.println("To add this product to cart press : "+ count);
				count++;
				System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			
				
			}
			
		by.processCart();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void processCart() throws SQLException {
		BuyProduct byy = new BuyProduct();
		int a ;
		
		
		
		System.out.println("Please press a number to add product to cart :");
		a = scan.nextInt();
		System.out.println("Please enter the quantity :");
		
	if (a==1) {
		longBook=scan.nextInt();
		list.add(60*longBook);
		map.put("My long book -> Qty : "+longBook,60*longBook);
		
		
	}else if (a==2) {
		scrapBook=scan.nextInt();
		list.add(50*scrapBook);
		map.put("My scrap book -> Qty "+ scrapBook,50*scrapBook);
		
	}else if (a==3) {
		pencilStripe=scan.nextInt();
		list.add(8*pencilStripe);
		map.put("Fun pencil stripes -> Qty "+pencilStripe,8*pencilStripe);
		
	}else if (a==4) {
		pencilMetallic=scan.nextInt();
		list.add(10*pencilMetallic);
		map.put("Fun pencil metallic -> Qty "+pencilMetallic,10*pencilMetallic);
		
	}else if (a==5) {
		sharpnerBasic=scan.nextInt();
		list.add(10*sharpnerBasic);
		map.put("Fun sharpners basic -> Qty "+sharpnerBasic,10*sharpnerBasic);
		
	}else if (a==6) {
		sharpnerLong=scan.nextInt();
		list.add(12*sharpnerLong);
		map.put("Fun sharpners long tip -> Qty "+sharpnerLong,12*sharpnerLong);
		
	}else if (a==7) {
		eraser=scan.nextInt();
		list.add(8*eraser);
		map.put("Fun dust free eraser -> Qty "+eraser,8*eraser);
		
	}else if (a==8) {
		crayons=scan.nextInt();
		list.add(40*crayons);
		map.put("Fun crayons -> Qty "+crayons,40*crayons);
		
	}else if (a==9) {
		pastels=scan.nextInt();
		list.add(50*pastels);
		map.put("Fun oil pastels -> Qty "+pastels,50*pastels);
		
	}else if (a==10) {
		ruler=scan.nextInt();
		list.add(20*ruler);
		map.put("Fun ruler -> Qty "+ruler,20*ruler);
		
	}
	System.out.println("Product added to the cart.");
	
	System.out.println("\nDo you want to continue shopping ? \nPress y to continue shopping\nPress any other key to go to payment");
	char b='y' ;
	int o =1;
  b= scan.next().charAt(0);

  if(b=='y') {
	  byy.buyNow();
	  
  }else {
	  int sum=0;
	   for(int s : list) {
		  
		   sum= sum+s;
		  
	   }
	  
	  Set<String> ks = map.keySet();
	  
	 Iterator<String> itr = ks.iterator();
	 while(itr.hasNext()) {
		 String next = itr.next();
		 System.out.print(next+" = Rs. ");
		 System.out.println(map.get(next));
		 
	 }
	 System.out.println("----------------------------------------------------------------------------------------------------------------------");
	 System.out.println("Total payable amount is : Rs. "+sum);
	 
  }
  
  }
}
