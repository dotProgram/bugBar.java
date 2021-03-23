<%-- 
    Document   : addProject
    Created on : 05-Mar-2021, 1:40:20 pm
    Author     : Lenovo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null; ResultSet resultset2 =null;%>
                                                                                <%
                                                                                        try{
                                                                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                                 //Class.forName("com.mysql.jdbc.Driver"); 
                                                                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
                                                                 //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", ""); 
                                                                   Statement statement = connection.createStatement() ;
                                                                   Statement statement2 = connection.createStatement() ;
                                                                   
                                                                   resultset =statement.executeQuery("select * from user") ;
                                                                   resultset2 =statement.executeQuery("select * from user") ;
                                                                   String first_name, last_name, concat, ids;
                                                                   int id;

                                                                                %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Issue</title>
    </head>
    <body bgcolor="steelblue">
        <h1>Add Issue Monkey</h1>
        <div align="center" style='margin-top: 1%; height:550px; background-color: orange;'">
<h1 align="center" > Issue Details</h1>
<form action="../LogIssue" method="post" >
			<table style="with: 50%">
			
					<tr><td></td>
                                                                                                                   <td><% try{
                                                                                                                                if(request.getAttribute("invalid")!= null && request.getAttribute("invalid").toString().equals("inval")){
                                                                                                                                   out.println("<span style='color:red;'>");
                                                                                                                                    out.println("Empty issue_title or issue_description");
                                                                                                                                    out.println("</span>");
                                                                                                                                }

                                                                                                                                    else if(  request.getAttribute("auth") != null && request.getAttribute("auth").toString().equals("invalid")){
                                                                                                                                   out.println("<span style='color:red;'>");
                                                                                                                                    out.println("Invalid Username or Password");
                                                                                                                                    out.println("</span>");
                                                                                                                                 }
                                                                                                                                                                    }
                                                                                                                            finally{}
                                                                                                                            %>
                                                                                                             </td></tr>	
                                                                                                                <tr>
                                                                                                                                                        <td>Project </td>
                                                                                                                                                        
                                                                                                                                                                                    <th align="left" > 
                                                                                                                    <select  name="assigned_user_id">
                                                                                                                                    <%  while(resultset2.next()){ 
                                                                                                                                                    //id =  resultset.getInt(1);  
                                                                                                                                                    ids =  resultset2.getString(1);  
                                                                                                                                                    first_name = resultset2.getString(2);
                                                                                                                                                    last_name = resultset2.getString(3);
                                                                                                                                                    concat = first_name + " "+ last_name;
                                                                                                                                                   // resultset.getString(6)
                                                                                                                                                    %>
                                                                                                                                                        <option name="ddid" value="<%= ids %>"><%= concat %></option>
                                                                                                                                        <% } %>
                                                                                                                      </select> 
                                        </th>
                                                                                                                                                                                                                              
                                                                                                            </tr>
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            <tr>
					<td>Issue Title</td>
					<td><input type="text" name="issue_title" style="width:550px;" /></td>
                                                                                                            </tr>
                                                    
                                                                                     <tr>
				<td>Assign to</td>
                                                        <%
                                                            /*
                                                                try{
                                                                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                                 //Class.forName("com.mysql.jdbc.Driver"); 
                                                                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
                                                                 //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", ""); 
                                                                   Statement statement = connection.createStatement() ;

                                                                   resultset =statement.executeQuery("select * from user") ;
                                                                   String first_name, last_name, concat, ids;
                                                                   int id;
*/
                                                                  %>
                                        
					<th align="left" > 
                                                                                                                    <select  name="assigned_user_id">
                                                                                                                                    <%  while(resultset.next()){ 
                                                                                                                                                    //id =  resultset.getInt(1);  
                                                                                                                                                    ids =  resultset.getString(1);  
                                                                                                                                                    first_name = resultset.getString(2);
                                                                                                                                                    last_name = resultset.getString(3);
                                                                                                                                                    concat = first_name + " "+ last_name;
                                                                                                                                                   // resultset.getString(6)
                                                                                                                                                    %>
                                                                                                                                                        <option name="ddid" value="<%= ids %>"><%= concat %></option>
                                                                                                                                        <% } %>
                                                                                                                      </select> 
                                        </th>
                                                                                                        
<th> </th>
				</tr>
                                                                                                                                                        <%
                                                                                                                        //**Should I input the codes here?**
                                                                                                                         connection.close();  
                                                                                                                                }
                                                                                                                                catch(Exception e)
                                                                                                                                {
                                                                                                                                     out.println("wrong entry"+e);
                                                                                                                                }
                                                                                                                        %>

                                
                                <tr>
				<td>Issue status</td>
                                        
					<th align="left" > 
                                                                                                                    <select  name="issue_status">
                                                                                                                                    <option>Open</option>
                                                                                                                                    <option>For Fixing</option>
                                                                                                                                    <option>For Testing</option>
                                                                                                                                    <option>Closed</option>
                                                                                                                        
                                                                                                                      </select> 
                                        </th>
                                                                                                        
<th> </th>
				</tr>
				<tr>
					<td>Issue Description</td>
					<td><textarea  name="issue_description" maxlength="1024" style="min-width: 550px ; max-width:550px; min-height: 150px; max-height: 150px;"/></textarea></td></tr>
				<td>Platform</td>
					<td><input type="text" name="platform" maxlength="24" /></td>
				</tr>
				</tr>
				<td>Platform Version</td>
					<td><input type="text" name="platform_version" maxlength="24" /></td>
				</tr>
                                <td>Browser </td>
					<td><input type="text" name="browser" maxlength="24" /></td>
				</tr>
		 <td>Browser Version</td>
					<td><input type="text" name="browser_version" maxlength="24" /></td>
				</tr>
                                </tr>
		 <td>Attach File</td>
					<td><input type="file" id="myfile" name="attached_file"></td>
				</tr>
                                </tr>
		 <td></td>
					<td></td>
				</tr>
                              
                                <tr>
		 <td></td>
					<td><input type="submit" value="Add Issue" /></td>
				</tr>
                                 </tr>
		 <td></td>
					<td></td>
				</tr>
                        </table>
			</form>
			</div>
    </body>
</html>
