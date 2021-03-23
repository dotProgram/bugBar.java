package projects;



import issues.viewIssues;
import java.io.*;  
import jakarta.servlet.*;  
import jakarta.servlet.http.*;  
import java.sql.*;  
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import profile.ClientDetails;
    
public class view2 extends HttpServlet  
        
{    
   
     
      @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
       
res.sendRedirect("admin/project.jsp");
}
    
     @Override
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
                      HttpSession session=req.getSession(); 
                       
                      
                                           
                                           if(session.getAttribute("role") == null){
                                           RequestDispatcher rd = req.getRequestDispatcher("../Login.jsp");
                                           res.sendRedirect("../Login.jsp");
                                           
                                           }  
                    PrintWriter out = res.getWriter();  
                    res.setContentType("text/html");  
                    out.println("<html><body>"); 
                    
                    
                    
                   
                    //project_uid
                    
                       //Importing  Profine Class Starts
                    
                      ClientDetails cd = new ClientDetails();
          try {
             
              ArrayList<String> UsersDetails = new  ArrayList<String>(); // To Derive Users Added By Logged Admin
              ArrayList<String> ProjectDetails = new  ArrayList<String>();  // To Derive Projects Added By Logged Admin
             UsersDetails = cd. admin_or_client_details("project_admin_relationship", "project_uid", 115);
             
             System.out.println("Fetching the Array list Project_uidv   servlet Class \t");
             UsersDetails.forEach(name -> System.out.println( "Reterived Unique Project Id for 115 user is : "+name+"\n"));
             
             
           //  System.out.println("Fetching the Array project_uid details inside servlet Class \t \n");
          //   ProjectDetails = cd. adminAddedProjectsDetails("project_admin_relationship", "project_uid", 11);
            // ProjectDetails.forEach(name -> System.out.println(name+"\n"));
             
             
             
          } catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(viewIssues.class.getName()).log(Level.SEVERE, null, ex);
          }
                    //Importing  Profine Class Ends
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                  //  out.println("<h3><a href=\"admin/index.jsp\">Back l</a></h3><br>");  
                    String isSetDelete = req.getParameter("delete");
                    String check_box = req.getParameter("checkbox");
                    ArrayList<String> checkbox_array = new ArrayList<String>();
                   // checkbox_array = req.getParameter("checkbox");
                    checkbox_array.add( req.getParameter("checkbox"));  
                    String multiple_check[]=req.getParameterValues("checkbox"); //get checkbox name value "chk_language" and store in language[] array  

                    //To Check if There is any Delete Requset by thr User
                       if( isSetDelete == null  ){
                   // if( isSetDelete.isEmpty()  ){
                    

                     out.println("isSetDelete is Empty"+" Checkbbox="+check_box); 
                    }
                                                    //TO CHECK IF THERE IS ANY **DELETE REQUSET** BY THR USER & IF TRUE PROCEED WITH ELSE STATEMENT --------------------------  STARTS
                                                 
                                                    else if( isSetDelete != null  && multiple_check  != null ){
                                                       
                                                            out.println(processDeleteRequest(isSetDelete, check_box, multiple_check , out,  checkbox_array) +"</br>"); 
                                                              
                                                    }
            
            //TO CHECK IF THERE IS ANY DELETE REQUSET BY THR USER & IF TRUE PROCEED WITH ELSE STATEMENT -------------------------- *ENDS*
         
         
         // TO RETRIEVE DATA OF USER FROM DATABASE          ******** |||||||||||||||||||||||||
         // *****TRY STATEMENT          *************** STARTS********|||||||||||||||||||||||||
                                                    try 
                                                    {  

                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();
                                                                        Statement stmt2 = con.createStatement(); 
                                                                        
                                                                        
                                                                                                                                    int loggedAdminId = Integer.parseInt(session.getAttribute("id").toString());
                                                                                                                                    ResultSet rs_psProjectAdminAss = stmt2.executeQuery("select * from project_admin_relationship where project_adminowner ="+"'"+loggedAdminId+"';");    System.out.println("select * from project_admin_relationship where project_adminowner =="+"'"+loggedAdminId+"';");
                                                                                                                                   // ResultSet rs = stmt.executeQuery("select * from project");    System.out.println("select * from project"); 
                                                                                                                                    out.println("<form action=projects method=post target=\"_blank\"> <input type=\"submit\" value=\"delete\" name=\"delete\"/>");  
                                                                                                                                    out.println("<table border=1 width=100% height=50% color=lightgreen>");  
                                                                                                                                    out.println("<tr><th>Select</th><th>Project-- Id</th><th>Project Name</th><th>Project Description</th><th>Project Unique Id</th><tr>");  
                                                                                                                                    
                                                                                                                                    
                                                                                                                                    
                                                                                                                                    // CHECKING CODE
                                                                                                                                                                                                                                        //String project_uid_in_ProjectAdminAss = rs_psProjectAdminAss.getString("project_uid");  
                                                                                                                                                                                                                                        ResultSet rs = stmt.executeQuery("select * from project where project_uid = '82d2b6e3-22b0-4248-b906-0a79921f6bc3' ;"); System.out.println("elect * from project where project_uid  = 82d2b6e3-22b0-4248-b906-0a79921f6bc3\n");
                                                                                                                                                                                                                                        rs.next();
                                                                                                                                                                                                                                        String project_name = rs.getString("project_name");              System.out.println("\n While loop  CHECKING CODE \n"); 
                                                                                                                                                                                                                                        String project_description = rs.getString("project_description");  
                                                                                                                                                                                                                                        String project_uid = rs.getString("project_uid");  
                                                                                                                                                                                                                                        int id = rs.getInt("id");   
                                                                                                                                                                                                                                        out.println("<tr style=\"cursor: pointer;\"  onclick=\"window.location='vad?id="+id+"&request=detail'\" data-href=\"vad\"><td><input type=checkbox id=check name=checkbox value="+ id +"></td><td>" + id + "</td><td>" + project_name + "</td><td>" + project_description + "</td><td>" + project_uid + "</td><td><input type=\"submit\" value=\"Delete\" name=\"delete\"/></td></tr>");   
                                                                                                                                                                                                                                        
                                                                                                                                    // CHECKING CODE
                                                                                                                                    
                                                                                                                                    
                                                                                                                                    
                                                                                                                                    
                                                                                                                                    while (rs_psProjectAdminAss.next()) // This While Loop Fetches Projects U_ID Associated with the logged Admin
                                                                                                                                {  
//                                                                                                                                                                                                                                 try //This TRY Fetches Projects Associated with the logged Admin With the help of Drived Projects U_ID From  while (rs_psProjectAdminAss.next()) 
//                                                                                                                                                                                                                                {
//                                                                                                                                                                                                                                        String project_uid_in_ProjectAdminAss = rs_psProjectAdminAss.getString("project_uid");  
//                                                                                                                                                                                                                                        ResultSet rs = stmt.executeQuery("select * from project where project_uid ="+"'"+project_uid_in_ProjectAdminAss+"';"); System.out.println("elect * from project where project_uid ="+project_uid_in_ProjectAdminAss+"\n");
//                                                                                                                                                                                                                                        String project_name = rs.getString("project_name");              System.out.println("While loop"); 
//                                                                                                                                                                                                                                        String project_description = rs.getString("project_description");  
//                                                                                                                                                                                                                                        String project_uid = rs.getString("project_uid");  
//                                                                                                                                                                                                                                        int id = rs.getInt("id");   
//                                                                                                                                                                                                                                        out.println("<tr style=\"cursor: pointer;\"  onclick=\"window.location='vad?id="+id+"&request=detail'\" data-href=\"vad\"><td><input type=checkbox id=check name=checkbox value="+ id +"></td><td>" + id + "</td><td>" + project_name + "</td><td>" + project_description + "</td><td>" + project_uid + "</td><td><input type=\"submit\" value=\"Delete\" name=\"delete\"/></td></tr>");   
//                                                                                                                                                                                                                                        
//                                                                                                                                                                                                                                 } 
//                                                                                                                                                                                                                                catch (SQLException e) 
//                                                                                                                                                                                                                                {  
//                                                                                                                                                                                                                                            out.println("2nd SQL Error \n");
//                                                                                                                                                                                                                                            System.out.println(e);
//                                                                                                                                                                                                                                            out.println(e);  
//                                                                                                                                                                                                                                 }  
                                                                                                                                }  
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                       
                                                                        
                                                                        
                                                                        out.println("</table> </form>");  

                                                                        out.println("</html></body>");  
                                                                        con.close();  
                                                         }  

                                                    // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                    // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////


                                                        catch (ClassNotFoundException | SQLException e) 
                                                       {  
                                                        out.println("error");  
                                                        out.println(e);  
                                                    }  
     }  //doPost ENDS /\/
     
     
     
     //Blow Class Methords
    private String  processDeleteRequest(String isSetDelete, String check_box, String multiple_check[], PrintWriter out, ArrayList<String> checkbox_array){
       
                                                            out.println("</br>"); 
                                                            out.println(check_box);             
                                                            out.println("</br>");            

                                                                //String language[]=request.getParameterValues("chk_language"); //get checkbox name value "chk_language" and store in language[] array

                                                                for(int i=0;i<multiple_check.length;i++) //apply loop for fecth multiple checkbox value
                                                                {
                                                                  out.println(multiple_check[i]+","); //fetch with comma separate
                                                                
                                                                
                                                                                            try 
                                                                                        {  
                                                                                            Class.forName("com.mysql.jdbc.Driver");  
                                                                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                                            // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                                            Statement stmt = con.createStatement();  
                                                                                            
                                                                                         //   ResultSet rs = stmt.executeUpdate("DELETE FROM user WHERE id="+multiple_check[i]+";");    System.out.println("<br>Real Delete Query Executer Successfully"); 
                                                                                            int rs = stmt.executeUpdate("DELETE FROM project WHERE id="+multiple_check[i]+";");
                                                                                           out.println("DELETE FROM project WHERE id="+multiple_check[i]+";"+" Int RS value = "+rs+"<br>");  
                                                                                            con.close();
                                                                                        }

                                                                                            catch (ClassNotFoundException | SQLException e) 
                                                                                           {  
                                                                                            out.println("Delete error<br>");  
                                                                                            
                                                                                            out.println(e);  
                                                                                        }
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                }


                                                              out.println("isSetDelete is not null : Value= "+isSetDelete+" Checkbbox, ArrayList: ="+check_box+","+checkbox_array); 
                                                              
                                                              try 
                                                             {  
                                                                 Class.forName("com.mysql.jdbc.Driver");  
                                                                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                 // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                 Statement stmt = con.createStatement();  
                                                                 ResultSet rs = stmt.executeQuery("select * from project");    System.out.println("<br>Delete Query Executer Successfully"); 
                                                                 con.close();
                                                             }

                                                                 catch (ClassNotFoundException | SQLException e) 
                                                                {  
                                                                 out.println("Delete error");  
                                                                 out.println(e);  
                                                             }
        
        return "processDeleteRequest Sussess";
     
     }
     
     
     
     
 }