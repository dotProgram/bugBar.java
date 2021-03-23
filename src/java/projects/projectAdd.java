package projects;
 

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
import java.util.UUID;

/**
 * Servlet implementation class guru_register
 */
public class projectAdd extends HttpServlet {
private static final long serialVersionUID = 1L;
     @Override   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
  //  response.sendRedirect("admin/addProject.jsp");
    
    }
        @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                                           //HttpSession session=request.getSession(false);  
                                           HttpSession session=request.getSession(); 
                                           
                                           if(session.getAttribute("role") == null){
                                           RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
                                           response.sendRedirect("Login.jsp");
                                           
                                           }
                                           
                                           
                                           
                                           
                                           
		String project_name = request.getParameter("project_name");
		String project_description = request.getParameter("project_description");
                                          

                                            String html_1 = "<html> <head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> </head> <body> <div>";
                                            String html_2 = "</div></body></html>";
                               



                                            String par = "Invalid Parameters";
                                            PrintWriter out = response.getWriter( );
                                            //JUST TO DISPLAY DATA
                                            request.setAttribute("project_name",project_name);
                                            request.setAttribute("project_description",project_description);


                                            //request.setAttribute("par",par);
                                           //out.println("This is the Test") ;
                                         // Creating a RequestDispatcher object to dispatch 
                                         // the request the request to another resource 


                                                if(project_name.isEmpty() || project_description.isEmpty() ){
                                            {
                                                request.setAttribute("invalid","inval");
                                                 RequestDispatcher rd =   request.getRequestDispatcher("admin/addProject.jsp");  
                                                 
                                                 //invalid = "inval";
                                                 rd.forward(request, response);     
                                                    //response.sendRedirect("Login.jsp");
                                                   //RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
                                                   // username = "Zero";
                                                  //req.include(request, response);
                                                   //out.println("<h1>Invalid Entries</h1>") ;
                                                 //response.sendRedirect("admin/Addproject.jsp");
                                                  System.out.println("project_name.isEmpty();"); }
                                                 
                                                  
                                          
                                                  
                                            
                                                            }
                                                    else
                                                    {
                                                    try {
                                                                                    System.out.println("Inside try com.mysql.jdbc.Driver com.mysql.jdbc.Driver");
                                                                                    Class.forName("com.mysql.jdbc.Driver");                                                                                                                                                                 System.out.println("Reached com.mysql.jdbc.Driver"); 
                                                                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                                    PreparedStatement ps = con.prepareStatement("insert into project (project_name,project_description,project_uid) values(?,?,?)");  System.out.println("Reached PreparedStatement");

                                                                                 // ps.setString(1,);
                                                                                    ps.setString(1, project_name);
                                                                                    ps.setString(2, project_description);
                                                                                    UUID uuid=UUID.randomUUID();
                                                                                    ps.setString(3, uuid.toString());
                                                                                   
                                                                                    
                                                                                    System.out.println("\n session id: "+session.getAttribute("id").toString());
                                                                                    int sessionUserID = Integer.parseInt(session.getAttribute("id").toString()); 
                                                                                  
                                                                                    int i = ps.executeUpdate();
                                                                                    if (i > 0){
                                                                                                        out.print("<h2>project successfully added...& sessionUserID ="+sessionUserID);
                                                                                                        out.print("uuid=  " +uuid.toString());

                                                                                                           
                                                                                                        
                                                                                                        
                                                                                                            try{
                                                                                                         // Now The Project is Added Successfully << Adding Project and Admin Association>>  project_adminowner
                                                                                                        PreparedStatement psProjectAdminAss = con.prepareStatement("insert into project_admin_relationship (project_uid, project_adminowner) values(?,?)");  System.out.println("\n Reached PreparedStatement \n << Adding Project and Admin Association>>  project_adminowner");
                                                                                                        psProjectAdminAss.setString(1, uuid.toString());
                                                                                                        psProjectAdminAss.setInt(2, sessionUserID);   
                                                                                                       
                                                                                                        psProjectAdminAss.executeUpdate();    
                                                                                                            }
                                                                                                        
                                                                                                            catch (SQLException e2) {
                                                                                                            System.out.println("\n"+e2);
                                                                                                                        }
                                                                                                        
                                                                                                        
                                                                                                        
                                                                                                        
                                                                                                        
                                                                                                        
                                                                                                        
                                                                                                        
                                                                                    }

                                                                                } catch (ClassNotFoundException | SQLException e2) {
                                                                                    System.out.println(e2);
                                                                                }

                                                                                                        } 


                                                    }//ENDS ELSE IF ALL DORM INPUT ARE FILLED
	
       // out.println("<br />");

  



/* private boolean  AuthenticityOfUserLoggingIn(String userIdDataEntered, String userIdPasswordEntered ){

    String password1=null;
    boolean ret = false;
                                                try 
                                                    {  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from user where userid ="+"'"+userIdDataEntered+"';");    System.out.println("select * from user where userid =="+"'"+userIdDataEntered+"';");
                                                                           while (rs.next()) 
                                                                        {  
                                                                             
                                                                            String userid = rs.getString("userid");  
                                                                            String password = rs.getString("password");  
                                                                            password1 =password;
                                                                            System.out.println("Password retrived"+"'"+password+"';");
                                                                            System.out.println("Password password1"+"'"+password1+"';");
                                                                            System.out.println("Password userIdPasswordEntered"+"'"+userIdPasswordEntered+"';");
                                                                        }  
                                                                           con.close();  
                                                                                                if(userIdPasswordEntered.equals(password1)  ){
                                                                                                
                                                                                                System.out.println("password match"); 
                                                                                                
                                                                                                 ret = true;
                                                                                                }
                                                                      
                                                                        
                                                         }  

                                                                                // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                                                // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////


                                                        catch (ClassNotFoundException | SQLException e) 
                                                       {  
                                                        
                                                       System.out.println(e);  
                                                    }  
            return ret;
           
     




}


*/


}//while
  
                
		 
 