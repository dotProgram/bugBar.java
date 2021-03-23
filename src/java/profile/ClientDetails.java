/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;
import java.io.*;  
import jakarta.servlet.*;  
import jakarta.servlet.http.*;  
import java.sql.*;  
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ClientDetails {
    
    
    public ArrayList<String> adminAddedUsersDetails(String database_table, String table_coulmn, int adminID) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName("com.mysql.jdbc.Driver");  
                                                                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();  
                                                                         ResultSet rs = stmt.executeQuery("select "+table_coulmn+" from "+database_table+" where id="+adminID+" || id = 115");    System.out.println("select "+table_coulmn+" from "+database_table+" where id="+adminID+" || id = 18"); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                            String requestedColumn = rs.getString(table_coulmn);  
                                                                            UsersDetails.add(requestedColumn);
                                                                           
//                                                                          String email = rs.getString("email");  
//                                                                          long phno = (long) rs.getDouble("phno");   
//                                                                          int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                            System.out.println("\n database_table = "+database_table+" & table_coulmn = "+table_coulmn ); 
                                                                            System.out.println("\n ArrayList<String> UsersDetails Fetching Array = "+UsersDetails+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return UsersDetails;
    }
    
    
    
        public ArrayList<String> adminAddedProjectsDetails(String database_table, String table_coulmn, int adminID) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName("com.mysql.jdbc.Driver");  
                                                                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();  
                                                                         ResultSet rs = stmt.executeQuery("select "+table_coulmn+" from "+database_table+" where project_adminowner="+adminID+" || id = 115");    System.out.println("select "+table_coulmn+" from "+database_table+" where id="+adminID+" || id = 18"); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                            String requestedColumn = rs.getString(table_coulmn);  
                                                                            UsersDetails.add(requestedColumn);
                                                                           
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+table_coulmn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array = "+UsersDetails+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return UsersDetails;
    }
      

       public ArrayList<String> admin_or_client_details(String database_table, String table_coulmn, int adminID) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName("com.mysql.jdbc.Driver");  
                                                                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();  
                                                                         ResultSet rs = stmt.executeQuery("select "+table_coulmn+" from "+database_table+" where project_adminowner = "+adminID);    System.out.println("select "+table_coulmn+" from "+database_table+" where id="+adminID+" || id = 18"); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                            String requestedColumn = rs.getString(table_coulmn);  
                                                                            UsersDetails.add(requestedColumn);
                                                                           
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+table_coulmn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array = "+UsersDetails+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return UsersDetails;
    }

        
        public int clientID(String database_table, String getThisColumn, String whereParameter, String whereParametervalue) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName("com.mysql.jdbc.Driver");  
                                                                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                        int idReturned=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            idReturned = rs.getInt("id"); 
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array The ID is= "+idReturned+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return idReturned;
    }
    
        
        public int insertIntoTable(String database_table, String ColumnName1, String ColumnName2, String value1, String value1) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName("com.mysql.jdbc.Driver");  
                                                                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("insert "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                        int idReturned=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            idReturned = rs.getInt("id"); 
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array The ID is= "+idReturned+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return idReturned;
    }
}
