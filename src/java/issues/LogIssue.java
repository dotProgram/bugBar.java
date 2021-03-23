package issues;
 

import demotest.*;
 import jakarta.servlet.SessionCookieConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class guru_register
 */
public class LogIssue extends HttpServlet {
private static final long serialVersionUID = 1L;
     @Override   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.sendRedirect("newIssue2.jsp");
    
    }
        @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub id =  resultset.getInt(1);  
                                           String ddid_value = request.getParameter("assigned_user_id");
                                           String ddid_value2 = request.getParameter("ddid");
                                         int   assigned_user_id_int = Integer.parseInt(ddid_value); 
		String issue_title = request.getParameter("issue_title");
		String assigned_user_id = request.getParameter("assigned_user_id");
                                           String issue_status = request.getParameter("issue_status");
		String issue_description = request.getParameter("issue_description");
                                           String platform = request.getParameter("platform");
		String platform_version = request.getParameter("platform_version");
                                           String browser = request.getParameter("browser");
                                           String browser_version = request.getParameter("browser_version");
                                           String attached_file = request.getParameter("attached_file");
		
                                           String html_1 = "<html> <head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> </head> <body> <div>";
                                           String html_2 = "</div></body></html>";
                                           // String invalid ;       



                                            String par = "Invalid Parameters";
                                            PrintWriter out = response.getWriter( );
                                            //JUST TO DISPLAY DATA
                                            request.setAttribute("issue_title",issue_title);
                                            request.setAttribute("issue_description",issue_description);


                                            //request.setAttribute("par",par);
                                           //out.println("This is the Test") ;
                                         // Creating a RequestDispatcher object to dispatch 
                                         // the request the request to another resource 


                                                if(issue_description.isEmpty() || issue_title.isEmpty() ){
                                            {
                                                request.setAttribute("invalid","inval");
                                                 RequestDispatcher rd =   request.getRequestDispatcher("newIssue2.jsp");  
                                                 
                                                 //invalid = "inval";
                                                 rd.forward(request, response);     
                                                    //response.sendRedirect("Login.jsp");
                                                   //RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
                                                   // username = "Zero";
                                                  //req.include(request, response);
                                                   //out.println("<h1>Invalid Entries</h1>") ;
                                                 //response.sendRedirect("admin/Addproject.jsp");
                                                  System.out.println("issue_description.isEmpty();"); 
                                                  System.out.println("assigned_user_id "+assigned_user_id); 
                                                  System.out.println("file "+attached_file); 
                                            }
                                                 
                                                  
                                          
                                                  
                                            
                                                            }
                                                    else
                                                    {
                                                    try {
                                                                              //      int assigned_user_id_int =43;
                                                                                    System.out.println("Inside try com.mysql.jdbc.Driver com.mysql.jdbc.Driver");
                                                                                    Class.forName("com.mysql.jdbc.Driver");                                                                                                                                                                 System.out.println("Reached com.mysql.jdbc.Driver"); 
                                                                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                                    PreparedStatement ps = con.prepareStatement("insert into logged_issue (issue_title,assigned_user_id,issue_status,issue_description,platform,platform_version,browser,browser_version,attached_file) values(?,?,?,?,?,?,?,?,?)");  System.out.println("Reached PreparedStatement");

                                                                                 // ps.setString(1,);
                                                                                    ps.setString(1, issue_title);
                                                                                    //ps.setString(2, assigned_user_id);
                                                                                    ps.setInt(2, assigned_user_id_int);
                                                                                    ps.setString(3, issue_status);
                                                                                    ps.setString(4, issue_description);
                                                                                    ps.setString(5, platform);
                                                                                    ps.setString(6, platform_version);                                                                                
                                                                                    ps.setString(7, browser);   
                                                                                    ps.setString(8, browser_version);                                                                                
                                                                                    ps.setString(9, attached_file);  
                                                                                    
                                                                                    int i = ps.executeUpdate();
                                                                                    if (i > 0)
                                                                                        out.print("<h2>You are successfully registered... </h2>");
                                                                                     out.print("             ddid=  "+ddid_value);
                                                                                      out.print("             ddid2=  "+ddid_value2);

                                                                                } catch (ClassNotFoundException | SQLException e2) {
                                                                                    System.out.println(e2);
                                                                                }

                                                                                                        } 
                 
                                                    }//ENDS ELSE IF ALL DORM INPUT ARE FILLED
	
}//while
  
                
		 
 