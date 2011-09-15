package com.tieto.examples.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * View Table
 * Try-with-resources demo.  
 * 
 * @author Pfeffer Vladimir
 *
 */
public class ViewTable {

	private static String tableName = "Coffees";
	
	/**
	 * Main method
	 * @param args parameters
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		SimpleConnection conn = new SimpleConnection(); 
		viewTable(conn);
	}
	
	public static void viewTable(SimpleConnection simpleConn) throws SQLException {

	    final String query = "SELECT COF_NAME, SUP_ID, PRICE, SALES, TOTAL from " + tableName;

	    try (Connection conn = simpleConn.getConnection(); 
	    	 Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {
	      
	      while (rs.next()) {
	        String coffeeName = rs.getString("COF_NAME");
	        int supplierID = rs.getInt("SUP_ID");
	        float price = rs.getFloat("PRICE");
	        int sales = rs.getInt("SALES");
	        int total = rs.getInt("TOTAL");
	        System.out.println(coffeeName + ", " + supplierID + ", " + price + ", " + sales + ", " + total);
	      }

	    } catch (SQLException e) {
	      System.err.println(e.getMessage());
	    }
	  }
	
	

}
