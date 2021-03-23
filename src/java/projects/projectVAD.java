package projects;



import java.io.*;  
import jakarta.servlet.*;  
import jakarta.servlet.http.*;  
import java.sql.*;  
import java.util.ArrayList;
    
public class projectVAD extends HttpServlet  
        
{    
   
     
      @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
                     PrintWriter out = res.getWriter();  
                     res.setContentType("text/html");  
                     out.println("<html><body>"); 
                    String request = req.getParameter("request");
                       int id = Integer.parseInt(req.getParameter("id"));
                       String project_name = req.getParameter("project_name");
                       String project_description = req.getParameter("project_description"); 


                       if(request.equals("update")){
                          out.println("<h1>Handeling the  update request</h1><br>");  

                         processUpdateRequest(out, id, project_name, project_description);
                        out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
                       res.sendRedirect(" vad?id="+id+"&request=detail");
                        out.println("Update Success! \n");  
           }
          
          else 
          res.sendRedirect("../projects/project.jsp");
          
          
         out.println("</body></html>");  
//res.sendRedirect("projects/project.jsp");
}
    
          @Override
          public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
          
                    PrintWriter out = res.getWriter();  
                    res.setContentType("text/html");  
                    out.println("<html><body>"); 
                    String request = req.getParameter("request");
                    int id = Integer.parseInt(req.getParameter("id"));
                    String project_name = req.getParameter("project_name");
                    String project_description = req.getParameter("project_description"); 
           
           
                     // Create a function to Reterive the Projects associated with the Logged Admin.
           
           
           
           
           
          
           if(request.equals("viewlist")){
             out.println("<h1>Handeling the view request</h1><br>");  
           processViewListRequest(out);
           out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
           }
           
           else if(request.equals("edit")){
             out.println("<h1>Handeling the edit request</h1><br>");  
        
           editDetailRequest(out, id);
           out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
           }
           
            else if(request.equals("detail")){
             out.println("<h1>Handeling the  detail request</h1><br>");  
        
           detailRequest(out, id);
           out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
           }
          
        
        
           else {
           // Handeling the  Wrong Request</h1>
       // res.sendRedirect("../error.jsp");
           out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
           }
                                                                          int number=210;  
                                                                         //Switch expression  
                                                                        switch(number){  
                                                                        case 10 -> System.out.println("10");
                                                                         case 20 -> {
                                                                          out.println("<h1>editDetailRequest</h1><br>");
                                                                          editDetailRequest(out);
                                                                                              }
                                                                        case 30 -> System.out.println("30");
                                                                        default -> System.out.println("Not in 10, 20 or 30");  
                                                            }
          //Case statements
          //Default case statement
          

             
                    String isSetDelete = req.getParameter("delete");
                    String check_box = req.getParameter("checkbox");
                    ArrayList<String> checkbox_array = new ArrayList<String>();
                   // checkbox_array = req.getParameter("checkbox");
                    checkbox_array.add( req.getParameter("checkbox"));  
                    String multiple_check[]=req.getParameterValues("checkbox"); //get checkbox name value "chk_language" and store in language[] array  

                
                       if( isSetDelete == null  ){
             
                    

                     out.println("isSetDelete is Empty"+" Checkbbox="+check_box); 
                    }
                                                    //TO CHECK IF THERE IS ANY **DELETE REQUSET** BY THR USER & IF TRUE PROCEED WITH ELSE STATEMENT --------------------------  STARTS
                                                 
                                                    else if( isSetDelete != null  && multiple_check  != null ){
                                                       out.println(processDeleteRequest(isSetDelete, check_box, multiple_check , out,  checkbox_array) +"</br>"); 
                                                              
                                                    }
            
            //TO CHECK IF THERE IS ANY DELETE REQUSET BY THR USER & IF TRUE PROCEED WITH ELSE STATEMENT -------------------------- *ENDS*
         
         
         // TO RETRIEVE DATA OF USER FROM DATABASE          ******** |||||||||||||||||||||||||
         // *****TRY STATEMENT          *************** STARTS********|||||||||||||||||||||||||
   out.println("</body></html>");                                                  
     }  //doPost ENDS /\/
   
     
     
          private String  processViewListRequest(PrintWriter out){
      try 
                                                    {  
                                                                        out.println("Inside Method processViewRequest");  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from project");    System.out.println("select * from project"); 
                                                                        out.println("<form action=projects/view method=post > <input type=\"submit\" value=\"delete\" name=\"delete\"/>");  
                                                                        out.println("<table border=1 width=100% height=50% color=lightgreen>");  
                                                                        out.println("<tr><th>Select</th><th>Project Id</th><th>Project Name</th><th>Project Description</th><th>Project Unique Id</th><tr>");  
                                                                        while (rs.next()) 
                                                                        {  
                                                                           
                                                                            String project_name = rs.getString("project_name");              System.out.println("While loop"); 
                                                                            String project_description = rs.getString("project_description");  
                                                                            String project_uid = rs.getString("project_uid");  
                                                                            
                                                                            int id = rs.getInt("id");   
                                                                            out.println("<tr><td><input type=checkbox id=check name=checkbox value="+ id +"></td><td>" + id + "</td><td>" + project_name + "</td><td>" + project_description + "</td><td>" + project_uid + "</td><td><input type=\"submit\" value=\"Delete\" name=\"delete\"/></td></tr>");   
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
     
     return "f";}
     
          private String  detailRequest(PrintWriter out, int id){
         
                                                                    try 
                                                    {  
                                                                        out.println("Inside Method processViewRequest");  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from project where id = " + id +";");    System.out.println("select * from project"); 
                                                                       
                                                                        while (rs.next()) 
                                                                        {  
                                                                           
                                                                            String project_name = rs.getString("project_name");              System.out.println("While loop"); 
                                                                            String project_description = rs.getString("project_description");  
                                                                            String project_uid = rs.getString("project_uid");  
                                                                            
                                                                       //     int id = rs.getInt("id");   
                                                                                                                                               out.println("<br>");
                                                                            out.println("<style>.left-col{width: 150px; text-align:left; } .right-col{float: right; }</style>");  
                                                                            out.println("<form action=vad method=get > ");  
                                                                            out.println("<input type=\"hidden\" id=\"custId\" name=\"id\" value=" + id +"> ");  
                                                                             out.println("<input type=\"hidden\" id=\"cId\" name=\"request\" value=edit >");  
                                                                            out.println("<table align=\"left\"  border=0 width=80% height=20% color=\"lightgreen\">");  
                                                                            out.println("<tr class=left-col><th></th><th><input class=right-col align=\"right\"  type=\"submit\" value=\"Edit detailss! \" /></th><th></th><tr>");
                                                                            out.println("<tr class=left-col><th>Project Id</th><th>"+id+"</th><tr>");
                                                                            out.println("<tr class=left-col><th>Project Unique</th><th>"+project_uid+"</th><tr>");  
                                                                            out.println("<tr class=left-col><th>Project  Name</th><th>"+project_name+"</th><tr>");  
                                                                            out.println("<tr class=left-col><th>Project Description</th><th>"+project_description+"</th><tr>");  
                                                                            out.println("<tr class=left-col><th>Project Members</th><th>"+project_name+"</th><tr>");  
                                                                           // out.println("<tr class=left-col><th>Select</th><th></th><tr>");  
                                                                            out.println("</table> </form><br>");  
                                                                            

                                                                             
                                                                         
                                                                        }  
                                                                       
                                                                        con.close();  
                                                         }  

                                                    // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                    // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////


                                                        catch (ClassNotFoundException | SQLException e) 
                                                       {  
                                                        out.println("error");  
                                                        out.println(e);  
                                                    }  
     
     
          
          
          
          
return "dell"; }
     
          private String  editDetailRequest(PrintWriter out, int id){
          
                                                                 try 
                                                    {  
                                                                        out.println("Inside Method processViewRequest");  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from project where id = " + id +";");    System.out.println("select * from project"); 
                                                                       
                                                                        while (rs.next()) 
                                                                        {  
                                                                           
                                                                            String project_name = rs.getString("project_name");              System.out.println("Edit While loop"); 
                                                                            String project_description = rs.getString("project_description");  
                                                                            String project_uid = rs.getString("project_uid");  
                                                                            
                                                                           // int id = rs.getInt("id");   
                                                                                                                                               out.println("<br>");
                                                                            out.println("<style>.left-col{width: 150px; text-align:left; } .right-col{float: right; }</style>");  
                                                                            out.println("<form action=vad method=post > ");  
                                                                            out.println("<table align=\"left\"  border=0 width=80% height=20% color=\"lightgreen\">");  
                                                                            out.println("<input type=\"hidden\" id=\"id\" name=\"id\" value=" + id +"> ");  
                                                                            out.println("<input type=\"hidden\" id=\"id\" name=\"request\" value=\"update\" ");  
                                                                            out.println("<tr class=left-col><th></th><th><input class=right-col align=\"right\"  type=\"submit\" value=\"Save \" /></th><th></th><tr>");
                                                                            out.println("<tr class=left-col><th>Project No.</th><th>"+id+"</th><tr>");
                                                                            out.println("<tr class=left-col><th>Project Unique</th><th>"+project_uid+"</th><tr>");
                                                                            out.println("<tr class=left-col><th>Project  Name</th><th><input type=\"text\" name=\"project_name\" style=\"min-width: 950px ; max-width:950px; maxlength=\"102\" value=\""+project_name+"\"/></th><tr>");  
                                                                            out.println("<tr class=left-col><th>Project Description</th><th><textarea name=\"project_description\" maxlength=\"1024\" style=\"min-width: 950px ; max-width:950px; min-height: 350px; max-height: 350px;\"/>"+project_description+"</textarea></th><tr>");  
                                                                            //out.println("<tr class=left-col><th>Project Members</th><th>"+project_name+"</th><tr>");  
                                                                           // out.println("<tr class=left-col><th>Select</th><th></th><tr>");  
                                                                            out.println("</table> </form>");  
                                                                            

                                                                             
                                                                         
                                                                        }  
                                                                       
                                                                        con.close();  
                                                         }  

                                                    // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                    // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////


                                                        catch (ClassNotFoundException | SQLException e) 
                                                       {  
                                                        out.println("error");  
                                                        out.println(e);  
                                                    }  
     
     
          
          
          
          
return "dell"; }
     
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
     
          private String  processUpdateRequest(PrintWriter out, int id, String project_name, String project_description ){
                                                    try {
                                                                                    System.out.println("\n  String project_name , "+project_name+"   String project_description,  "+project_description+"  id =  "+id+"" );
                                                                                    System.out.println("\n Inside processUpdateRequest\n ");
                                                                                    System.out.println("UPDATE try com.mysql.jdbc.Driver com.mysql.jdbc.Driver");
                                                                                    Class.forName("com.mysql.jdbc.Driver");                                                                                                                                                                 System.out.println("Reached com.mysql.jdbc.Driver"); 
                                                                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                                  //  PreparedStatement ps = con.prepareStatement("update project set (project_name, project_description) values(?,?) where id = " + id +";");  System.out.println("Reached UPDATE PreparedStatement");
                                                                                    PreparedStatement ps = con.prepareStatement("update project set project_name = '"+project_name +"', project_description  = '"+ project_description +"'  where id = " + id +";"); System.out.println("Reached UPDATE PreparedStatement");
                                                                                 // ps.setString(1,);
                                                                                  //  ps.setString(1, project_name);
                                                                                    //ps.setString(2, project_description);
                                                                                   
                                                                                  
                                                                                    int i = ps.executeUpdate();
                                                                                    if (i > 0)
                                                                                        out.print("<h2>Update Success!.</h2>");

                                                                                } 
                                                    
                                                                        catch (ClassNotFoundException | SQLException e2) {
                                                                                    System.out.println(e2);
                                                                                    out.print("<h2>Update Failure!.</h2>");
                                                                                }
     
     return "Update Success";
 }