package com.tieto.examples.db;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * RowSetFactory demo
 * 
 * @author Vladimir Pfeffer
 *
 */
public class RowSetFactoryDemo {
	
	/**
	 * Create JdbcRowSet by RowSetFactory
	 * Simple connect to DB
	 * Execute DB query
	 * Display fetched data 
	 *  
	 */
	public void testJdbcRowSet() {
	
		RowSetFactory myRowSetFactory = null;
		JdbcRowSet jdbcRs = null;
		
		try {			
			myRowSetFactory = RowSetProvider.newFactory();
			jdbcRs = myRowSetFactory.createJdbcRowSet();
			jdbcRs.setUrl(SimpleConnection.DB_URL);			
			jdbcRs.setCommand("SELECT COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES");
			jdbcRs.execute();
						
			while (jdbcRs.next()) {
		        String coffeeName = jdbcRs.getString("COF_NAME");
		        int supplierID = jdbcRs.getInt("SUP_ID");
		        float price = jdbcRs.getFloat("PRICE");
		        int sales = jdbcRs.getInt("SALES");
		        int total = jdbcRs.getInt("TOTAL");
		        System.out.println(coffeeName + ", " + supplierID + ", " + price + ", " + sales + ", " + total);
		      }
					
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}
	
}
