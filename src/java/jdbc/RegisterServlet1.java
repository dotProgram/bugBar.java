package jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
 import profile.ClientDetails;

 



public class RegisterServlet1 extends HttpServlet {
    
    
  
    
    
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside doPOST");
 
        response.setContentType("text/html");
        
        try (PrintWriter out = response.getWriter()) {
        
            String userType = request.getParameter("type");
            String firstN = request.getParameter("firstN");
            String lName = request.getParameter("lName");
            String userid = request.getParameter("userid");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phno_String = request.getParameter("phno");
            int phno = Integer.parseInt(phno_String); 
            
            try {
                System.out.println("Inside try com.mysql.jdbc.Driver com.mysql.jdbc.Driver");
                Class.forName("com.mysql.jdbc.Driver");                                                                                                                                                                 System.out.println("Reached com.mysql.jdbc.Driver"); 
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                PreparedStatement ps = con.prepareStatement("insert into user (firstN,lName,userid,password,email,phno,role) values(?,?,?,?,?,?,?);");  System.out.println("Reached PreparedStatement");
                PreparedStatement retUserID = con.prepareStatement("select id from ");
                //PreparedStatement admin_user_relationship = con.prepareStatement("select id from ");
             // ps.setString(1,);
                ps.setString(1, firstN);
                ps.setString(2, lName);
                ps.setString(3, userid);
                ps.setString(4, password);
                ps.setString(5, email);
                ps.setString(7, userType);
                    ps.setInt(6, phno);
                int i = ps.executeUpdate();
                if (i > 0)
                 out.print("<h2>You are successfully registered...</h2>\n Now Adding Admin User REl");
                ClientDetails cd2 = new ClientDetails();
                  System.out.println("Returned ID is \t haha");
               
                                                                                              try{
                                                                                                     // Now The Project is Added Successfully << Adding Project and Admin Association>>  project_adminowner
                                                                                                        PreparedStatement admin_user_relationship = con.prepareStatement("insert into admin_user_relationship (adminID, userID) values(?,?)");  System.out.println("\n Reached PreparedStatement OF NESTED TRY \n << admin_user_relationship>>  admin_user_relationship");
                                                                                                    //  admin_user_relationship.setString(1, uuid.toString());
                                                                                                  //    admin_user_relationship.setInt(2, sessionUserID);   
                                                                                                        admin_user_relationship.setString(1, "uuid.toString()");
                                                                                                        admin_user_relationship.setString(2, "sessionUkserID");   
                                                                                                       
                                                                                                            if(admin_user_relationship.executeUpdate() >= 1)
                                                                                                           System.out.println("\n insert into Admin User Rel = SUCCESS \n ");
                                                                                              }
                                                                                                        
                                                                                                            catch (SQLException e2) {
                                                                                                            System.out.println("\n"+e2);
                                                                                                                        }
                  
                  
                  
                  
                  
                 // cd2.insertIntoTable("admin_user_relationship", "adminID"," userID", "adminIDValue", "userIDValue");
                 System.out.println(returnedID);
                  con.close();  
                
                 } catch (ClassNotFoundException | SQLException e2) {
                System.out.println(e2);
            }
 
}
}
}