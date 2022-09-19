package com.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowProductList {
	PreparedStatement ps = null;
	Connection con = null ;
	ConnectionTest test = new ConnectionTest();
	
	
	public void buyNow() {
		BuyProduct by = new BuyProduct();
		int count =1;
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
	
	
	
	
//	ps = con.prepareStatement("select * from productlist"); 
//	ResultSet rs =ps.executeQuery();
//	
//	while (rs.next()) {
//		 if(l==rs.getInt(1)) {
//		int la= rs.getInt(5);
//		lb=la-longBook;
//		
//		}
//		 }
//	
	public void quantitySubstraction( ) throws SQLException {
		List<Integer> list = new ArrayList<Integer>();
		System.out.println();
		System.out.println("hii");
		PreparedStatement p ;
		int l=1;
		//int sum =data.book();
		try {
			
			System.out.println(BuyProduct.lb);
				con=test.getConnection();
				ps = con.prepareStatement("Select * from productlist"); 
				ResultSet rs =ps.executeQuery();
				p=con.prepareStatement("update productlist set quantity = ? where productId=?;");
			while (rs.next()) {
				 if(l==rs.getInt(1)) {
				int la= rs.getInt(5);
				 //la=(la-data.book());
				 
				 p.setInt(1,la);
				p.setInt(2,1);
				p.executeUpdate();
				 }
					}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}
