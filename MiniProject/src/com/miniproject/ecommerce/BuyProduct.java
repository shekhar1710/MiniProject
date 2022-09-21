package com.miniproject.ecommerce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BuyProduct {
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	Connection con = null ;
	   static	String a ;

	// Scanner scan = new Scanner(System.in);
	static int lbo,sc,pst,pm,sb,sl,ed,cr,pa,ru ;
	static int longBook,scrapBook,pencilStripe,pencilMetallic,sharpnerBasic,sharpnerLong,eraser,crayons,pastels,ruler ;
	static List<Integer> list = new ArrayList<Integer>();
	static List<String> list2 = new ArrayList<>();
	static List<Integer> list3 = new ArrayList<>();
	static List<Integer> list4 = new ArrayList<>();
	
	ShowProductList show = new ShowProductList();
 
	
	
 public void buyNow() {
	 
		BuyProduct by = new BuyProduct();
		int count =1;
		try {
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps = con.prepareStatement("select * from productlist"); 
			ResultSet rs =ps.executeQuery();
			System.out.println("---------------------------");
			System.out.println("|   ***Product list***    |");
			System.out.println("---------------------------");
			while(rs.next()) {
				
				System.out.println("Product Id :"+rs.getString(1));
				System.out.println("Product Name :"+rs.getString(2));
				System.out.println("Description :"+rs.getString(3));
				System.out.println("Price :Rs."+rs.getString(4));
				System.out.println("To add this product to cart press : "+ count);
				count++;
				System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			}
			con.close();
			ps.close();
			rs.close();
		by.processCart();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
 
 
	public void processCart() throws SQLException {
		Scanner scan = new Scanner(System.in);

		BuyProduct buy = new BuyProduct();
		
		ConnectionTest test = new ConnectionTest();
		con=test.getConnection();
		ps3 = con.prepareStatement("update productlist set quantity = ? where productId=?;"); 
		ps2 = con.prepareStatement("select * from productlist"); 
		ResultSet sr =ps2.executeQuery();
		try {
		while (sr.next()) {
			 if(1==sr.getInt(1)) {
			lbo= sr.getInt(5);
		    }else if (2==sr.getInt(1)) {
			sc=sr.getInt(5);
		    }else if (3==sr.getInt(1)) {
			pst=sr.getInt(5);
			}else if(4==sr.getInt(1)) {
				pm=sr.getInt(5);
			}else if(5==sr.getInt(1)) {
				sb=sr.getInt(5);
			}else if(6==sr.getInt(1)) {
				sl=sr.getInt(5);
			}else if(7==sr.getInt(1)) {
				ed=sr.getInt(5);
			}else if(8==sr.getInt(1)) {
				cr=sr.getInt(5);
			}else if(9==sr.getInt(1)) {
				pa=sr.getInt(5);
			}else if(10==sr.getInt(1)) {
				ru=sr.getInt(5);
			}
			}
		System.out.println("\nPlease press a number to add product to cart 🛒:");
		a = scan.next();
		System.out.println("Please enter the quantity :");
		
	if (a.equals("1")) {
		longBook=scan.nextInt();
		if(longBook>lbo || longBook<0) {
			
		throw new InvalidInputException("Please select quantity less than "+lbo);
		
		}else {
			list.add(60*longBook);
			list2.add("My long book 📔 -> Qty   ");
			list3.add(longBook);
			list4.add(1);
			
		}
		}else if (a.equals("2")) {
		scrapBook=scan.nextInt();
		if(scrapBook<sc && scrapBook>0) {
		list.add(50*scrapBook);
		list2.add("My scrap book -> Qty    ");
		list3.add(scrapBook);
		list4.add(2);
		
		}else {
		
			throw new InvalidInputException("please select quantity less than "+sc);
		}
		}else if (a.equals("3")) {
		pencilStripe=scan.nextInt();
		if(pencilStripe<pst && pencilStripe>0) {
		list.add(8*pencilStripe);
		list2.add("Fun pencil stripes -> Qty  ");
		list3.add(pencilStripe);
		list4.add(3);
		
		}else {
		
			throw new InvalidInputException("please select quantity less than "+pst);
		}
		}else if (a.equals("4")) {
		pencilMetallic=scan.nextInt();
		if(pencilMetallic<pm && pencilMetallic>0) {
		list.add(10*pencilMetallic);
		list2.add("Fun pencil metallic -> Qty");
		list3.add(pencilMetallic);
		list4.add(4);
	
		}else {
			
			throw new InvalidInputException("please select quantity less than "+pm);
		}
		}else if (a.equals("5")) {
		sharpnerBasic=scan.nextInt();
		if(sharpnerBasic<sb && sharpnerBasic>0) {
		list.add(10*sharpnerBasic);
		list2.add("Fun sharpners basic -> Qty");
		list3.add(sharpnerBasic);
		list4.add(5);

		}else {
			
			throw new InvalidInputException("please select quantity less than "+sb);
		}
		}else if (a.equals("6")) {
		sharpnerLong=scan.nextInt();
		if(sharpnerLong<sl && sharpnerLong>0) {
		list.add(12*sharpnerLong);
		list2.add("Fun sharpners long tip -> Qty");
		list3.add(sharpnerLong);
		list4.add(6);

		}else {
			
			throw new InvalidInputException("please select quantity less than "+sl);
		}
		}else if (a.equals("7")) {
		eraser=scan.nextInt();
		if(eraser<ed && eraser>0) {
		list.add(8*eraser);
		list2.add("Fun dust free eraser -> Qty  ");
		list3.add(eraser);
		list4.add(7);
	
		}else {
			
			throw new InvalidInputException("please select quantity less than "+ed);
		}
		}else if (a.equals("8")) {
		crayons=scan.nextInt();
		if(crayons<cr && crayons>0) {
		list.add(40*crayons);
		list2.add("Fun crayons -> Qty    ");
		list3.add(crayons);
		list4.add(8);
	
		}else {
			
			throw new InvalidInputException("please select quantity less than "+cr);
		}
		}else if (a.equals("9")) {
		pastels=scan.nextInt();
		if(pastels<pa && pastels>0) {
		list.add(50*pastels);
		list2.add("Fun oil pastels -> Qty     ");
		list3.add(pastels);
		list4.add(9);

		}else {
			
			throw new InvalidInputException("please select quantity less than "+pa);
		}
		}else if (a.equals("10")) {
		ruler=scan.nextInt();
		if(ruler<ru && ruler>0) {
		list.add(20*ruler);
		list2.add("Fun ruler -> Qty      ");
		list3.add(ruler);
		list4.add(10);

		}else {
			scan.close();
			throw new InvalidInputException("please select quantity less than "+ru);
		}
	}else {
		
		throw new InvalidInputException("Invalid option selected");
		
	}
show.processCart();
		}catch(InvalidInputException e) {
		  System.err.println("\n\n"+e);
		  
		  System.out.println("\n\nPress 1 : To select the product again.");
			
			System.out.println("Press any other key to exit.");
			
			String k =scan.next();
			if(k.equals("1")) {
				buy.buyNow();
			}else{
				System.out.println("\n\n\n         Thank You ...\n         Visit again...");
				System.exit(0);
			}
	  }	
	}		
}
 