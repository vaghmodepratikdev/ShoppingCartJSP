package isi.exo.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import isi.exo.entity.productentity;
import isi.exo.service.DBConnectionService;

public class productManager {
	private static String getAllProduct="select * from  productinfo"; 
	private static String getProductByName="select from  productinfo where name = ?";
	private static String getProductByCategory="select from  productinfo where category = ?";

	public static ArrayList<productentity> getaAllProduct()
	{
		ArrayList<productentity> productList = new ArrayList<productentity>();
		try
		{
			Statement statement =DBConnectionService.getStatementObject();
			
			ResultSet rs=statement.executeQuery(getAllProduct);
			
			while(rs.next()) {
				productentity product = new productentity(
							rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_category"),
							rs.getInt("product_quantity"),
							rs.getString("product_description"),
						rs.getString("product_image"));
				
				productList.add(product);
							 }
			return productList;
			
		}
		
	 catch (SQLException e) {
		e.printStackTrace();
	}
		return productList;
	}
	
	public static ArrayList<productentity> getProductByName(String productname)
	{
ArrayList<productentity> listOfProducts = new ArrayList<productentity>();
		
		try {
			PreparedStatement ps = DBConnectionService.getPreparedStatement(getProductByName);
			ps.setString(1, productname);
			
			
			ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 productentity product = new productentity(
						 rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_category"),
							rs.getInt("product_quantity"),
							rs.getString("product_description"),
						rs.getString("product_image"));

					
				 listOfProducts.add(product);
				 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProducts;
}

	
	public static ArrayList<productentity> getProductByCategory(String category)
	{
ArrayList<productentity> listOfProducts = new ArrayList<productentity>();
		
		try {
			PreparedStatement ps = DBConnectionService.getPreparedStatement(getProductByCategory);
			ps.setString(1, category);
			
			
			ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 productentity product = new productentity(
						 rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_category"),
							rs.getInt("product_quantity"),
							rs.getString("product_description"),
						rs.getString("product_image"));

					
				 listOfProducts.add(product);
				 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProducts;
}
	
}
