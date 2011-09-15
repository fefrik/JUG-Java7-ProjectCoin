package com.tieto.examples.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SimpleConnection {

	public static String DB_URL = "jdbc:derby://localhost:1527/test;create=true";
    

    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
	
    public SimpleConnection() {	    
      try {
         Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
         conn = DriverManager.getConnection(DB_URL);
         
      }
      catch (Exception except) {
         except.printStackTrace();
      }           
    }
	 
	 public Connection getConnection() {
		 return this.conn;
	 }
}
