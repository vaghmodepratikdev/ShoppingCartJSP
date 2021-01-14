package isi.exo.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import isi.exo.entity.orderentity;
import isi.exo.service.DBConnectionService;

public class orderManager {
private static String getAllOrder="select * from  orderinfo"; 
	
	
	public static ArrayList<orderentity> getaAllOrder()
	{
		ArrayList<orderentity> orderList = new ArrayList<orderentity>();
		try
		{
			Statement statement =DBConnectionService.getStatementObject();
			ResultSet rs=statement.executeQuery(getAllOrder);
			
			while(rs.next()) {
				orderentity order = new orderentity(
						rs.getInt("orderId"),
						rs.getInt("productId"),
						rs.getInt("quantity"),
						rs.getInt("userid"));
				
				orderList.add(order);
				
			 }
			
		}
		
	 catch (SQLException e) {
		e.printStackTrace();
	}
		return orderList;
	}


}
