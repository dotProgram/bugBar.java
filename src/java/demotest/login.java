package demotest;
 

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class guru_register
 */
public class login extends HttpServlet {
private static final long serialVersionUID = 1L;
     @Override   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.sendRedirect("Login.jsp");
    
    }
        @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                 int Authenticity;
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
                                          String html_1 = "<html> <head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> </head> <body> <div>";
                                            String html_2 = "</div></body></html>";
                                           // String invalid ;       



                                            String par = "Invalid Parameters";
                                            PrintWriter out = response.getWriter( );
                                            //JUST TO DISPLAY DATA
                                            request.setAttribute("username",username);
                                            request.setAttribute("password",password);


                                                if(username.isEmpty() || password.isEmpty() ){
                                            {
                                                 RequestDispatcher rd =   request.getRequestDispatcher("pr/login.jsp");  
                                                 //RequestDispatcher rd2= response.
                                                 request.setAttribute("invalid","inval");
                            
                                              
                                              //   rd.forward(request, response);     
                                              response.sendRedirect("pr/login.jsp");
                                                
                                               
                                            }
                                                            }
                                                    else
                                                    {
                                                    //SRART ELSE IF ALL DORM INPUT ARE FILLED
                                                    HttpSession session=request.getSession();  
                                                    
                                                    // AuthenticityOfUserLoggingIn(username, password, session) Checks if the Client is ADMIN OR A USER
                                                    Authenticity = AuthenticityOfUserLoggingIn(username, password, session);
                                                    System.out.println("\nAuthenticityOfUserLoggingIn= "+Authenticity);
                                                    System.out.println("\n gET SESSION VARIABLE ID = "+session.getAttribute("id")); 
                                                     System.out.println("\n gET SESSION VARIABLE ROLE  = "+session.getAttribute("role"));
                                                     System.out.println("\n gET SESSION VARIABLE user_name  = "+session.getAttribute("user_name")); 
                                                                                    if(Authenticity == 1){ 

                                                                                   
                                                                                   session.setAttribute("user","Database Pass");
                                                                                   session.setAttribute("s_name",username+"  <br />This is Session Variable <br />");  
                                                                                   session.setAttribute("role","user");
                                                                                   out.println(html_1);
                                                                                   out.println("</br>Session is :"+session.getAttribute("s_name1"));
                                                                                   out.println("</br><strong>" + username + "</strong>  <br /><strong>" + password + "</strong>  <br /><strong>" + username + "</strong> : <br /><strong>" + password + "</strong> : <br />");
                                                                                   out.println("</br>This is Servlet Login");    
                                                                                   RequestDispatcher req = request.getRequestDispatcher("user.jsp");
                                                                                   //req.forward(request, response);
                                                                                   response.sendRedirect("user.jsp");


                                                                                   //out.print("</br>Welcome Aession, "+username); 
                                                                                  // out.println(html_2); 

                                                                                                               }  


                                                                                                                                        else if(Authenticity == 2){ 

                                                                                  // HttpSession session=request.getSession();  
                                                                                   session.setAttribute("admin","Database Pass");
                                                                                   session.setAttribute("role","admin");
                                                                                   session.setAttribute("s_name",username+"  <br />This is Session Variable <br />"); 
                                                                                   
                                                                                   out.println(html_1);
                                                                                   out.println("</br>This is an Admin account<br>");
                                                                                   out.println("</br>Session is :"+session.getAttribute("s_name1"));
                                                                                   out.println("</br><strong>" + username + "</strong>  <br /><strong>" + password + "</strong>  <br /><strong>" + username + "</strong> : <br /><strong>" + password + "</strong> : <br />");
                                                                                   out.println("</br>This is Servlet Login");    
                                                                                   RequestDispatcher req = request.getRequestDispatcher("welcome2.jsp");
                                                                                   //req.forward(request, response);
                                                                                   response.sendRedirect("welcome2.jsp");


                                                                                   //out.print("</br>Welcome Aession, "+username); 
                                                                                  // out.println(html_2); 

                                                                                                               }  


                                                                                                                                         else if(Authenticity == 0) { 
                                                                    // out.println(html_2);
                                                                                     //request.getRequestDispatcher("Login.html").include(request, response);
                                                                                    // response.sendRedirect("Login.jsp");
                                                                      System.out.println("Sorry, username or password error!");  
                                                                     // response.sendRedirect("Login.jsp");
                                                                      request.setAttribute("auth","invalid");
                                                                     RequestDispatcher rd =   request.getRequestDispatcher("Login.jsp");  

                                                                                   rd.forward(request, response);     

                                                                   } 
                                                                                  // requestDispatcher req = request.getRequestDispatcher("welcome.jsp");
                                                    //req.forward(request, response);
                                                    //response.sendRedirect("welcome.jsp");

                                                    }//ENDS ELSE IF ALL DORM INPUT ARE FILLED
	}
       // out.println("<br />");

  



private int  AuthenticityOfUserLoggingIn(String userIdDataEntered, String userIdPasswordEntered, HttpSession session ){

    String password1=null;
    int ret = 0;
    int id=0 ;
    String role_of_the_logged_user = null, userid = null, password = null;
 
                                                try 
                                                    {  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from user where userid ="+"'"+userIdDataEntered+"';");    System.out.println("select * from user where userid =="+"'"+userIdDataEntered+"';");
                                                                           while (rs.next()) 
                                                                        {  
                                                                             id = rs.getInt("id");  
                                                                            userid = rs.getString("userid");  
                                                                            password = rs.getString("password");
                                                                            role_of_the_logged_user = rs.getString("role");  
                                                                            password1 =password;
                                                                            System.out.println("Password retrived"+"'"+password+"';");
                                                                            System.out.println("Password password1"+"'"+password1+"';");
                                                                            System.out.println("Password userIdPasswordEntered"+"'"+userIdPasswordEntered+"'; \n");
                                                                       
                                                                            
                                                                        }  
                                                                         
                                                                                                if(userIdPasswordEntered.equals(password1)){
                                                                                                //To Retrieve if USER IS ADMIN
                                                                                         
                                                                                                if(role_of_the_logged_user.equals("admin") ){
                                                                                                
                                                                                                System.out.println("\n role_of_the_logged_user.equals = "+role_of_the_logged_user+"  id is :"+id+" AND user_name :"+userid); 
                                                                                                session.setAttribute("user_name", userid);
                                                                                                session.setAttribute("id",id);
                                                                                                session.setAttribute("logged_user_id", id);
                                                                                                 ret = 2;
                                                                                                }
                                                                                                
                                                                                                else{
                                                                                                    System.out.println("\n if_user_is_admin. NOT FOUND value = "+role_of_the_logged_user+"   id is"+id+" AND user_name :"+userid);
                                                                                                     session.setAttribute("user_name", userid);
                                                                                                     session.setAttribute("id",id);
                                                                                                     session.setAttribute("logged_user_id",id);
                                                                                                    ret = 1;
                                                                                                }
                                                                                                System.out.println("password match   ret set = 1"); 
                                                                                                
                                                                                                 
                                                                                                }
                                                                      
                                                                          con.close();  
                                                         }  

                                                                                // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                                                // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////


                                                        catch (ClassNotFoundException | SQLException e) 
                                                       {  
                                                        
                                                       System.out.println(e);  
                                                    }  
                                                
            return ret;
           
     




}





}//while
  
                
		 
 