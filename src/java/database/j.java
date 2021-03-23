package database;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.*;
//import database


// This class can be used to initialize the database connection 
public class j { 
	public static Connection initializeDatabase() 
		throws SQLException, ClassNotFoundException 
	{ 
            
		// Initialize all the information regarding 
		// Database Connection 
		String dbDriver = "com.mysql.jdbc.Driver"; 
		String dbURL = "jdbc:mysql://localhost:3306/"; 
		// Database name to access 
		String dbName = "servlet"; 
		String dbUsername = "root"; 
		String dbPassword = ""; 

		Class.forName(dbDriver); 
		Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername,dbPassword); 
                                           System.out.println("Success");
		return con; 
                
	} 
        
       Connection x ;
/*
    public j() throws SQLException, ClassNotFoundException {
        this.x = initializeDatabase();
    }
        */
} 
