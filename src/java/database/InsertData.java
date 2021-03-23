 //package database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.*; 
//import java.sql.PreparedStatement; 
  
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
  
// Import Database Connection Class file 
import database.DatabaseConnection; 
  
// Servlet Name 
@WebServlet("/InsertData") 
public class InsertData extends HttpServlet { 
    private static final long serialVersionUID = 1L; 
  
    @Override
    protected void doPost(HttpServletRequest request,  
HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        try { 
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            try ( //id	firstN	lName	userid	password	email	phno	time
            // Initialize the database
                    Connection con = DatabaseConnection.initializeDatabase(); // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
                    PreparedStatement st = con
                            .prepareStatement("insert user values(?, ?,?,?,?,?)")) {
                
                // For the first parameter,
                // get the data using request object
                // sets the data to st pointer
                // st.setInt(1, Integer.valueOf(request.getParameter("id")));
                st.setInt(1, Integer.valueOf(request.getParameter("1")));
                
                // Same for second parameter
                st.setString(2, request.getParameter("string"));
                
                // Execute the insert command using executeUpdate()
                // to make changes in database
                st.executeUpdate();
                
            }
  
            // Get a writer pointer  
            // to display the successful result 
            PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>"); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 