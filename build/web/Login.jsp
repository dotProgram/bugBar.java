<%-- 
    Document   : logindo
    Created on : 21-Feb-2021, 2:57:52 pm
    Author     : Lenov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="lightblue">
<div align="center" style='margin-top: 15%; background-color: white;'">
<h1 align="center" > Login</h1>
<form action="login" method="post" >
			<table style="with: 50%">
			<tr>
					<td></td><td><% try{
    if(request.getAttribute("invalid")!= null && request.getAttribute("invalid").toString().equals("inval")){
       out.println("<span style='color:red;'>");
        out.println("Empty Username or Password");
        out.println("</span>");
    }
    
        else if(  request.getAttribute("auth") != null && request.getAttribute("auth").toString().equals("invalid")){
       out.println("<span style='color:red;'>");
        out.println("Invalid Username or Password");
        out.println("</span>");
     }
       else if(  session.getAttribute("role") == null){
       out.println("<span style='color:red;'>");
        out.println("Session Expired, Please Login Again!");
        out.println("</span>");
     }
                                        }
finally{}
%>
                                        </td>
                                        
					
				</tr>	
                            <tr>
					<td>User Name</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				
				</tr></table>
			<input type="submit" value="Submit" /></form>
			</div>
 
<h1>Request Database Data</h1>
 <form action="../display" method="post">
 
       
        <input type="submit" value="Submit"/>
 
    </form>



</body>
</html>
