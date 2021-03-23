<%-- 
    Document   : register_2
    Created on : 15-Feb-2021, 11:59:36 am
    Author     : Lenovo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if(session.getAttribute("user")== null){
     response.sendRedirect("Login.jsp");
   
     }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> User Page</title>
</head>
<body bgcolor="skyblue">
           <a><br>Welcome USER!!!!</br></a>
           <a><br>Welcome ${username}!!!!</br></a>
         <span><%= session.getAttribute("user_name")%>         </span><br>
         <span>id= <%= session.getAttribute("id") %>         </span><br>
         <span> Session name<%= session.getAttribute("logged_user_id") %>         </span><br><br>
         
         
         
         <span> <h1>This is the USER.jsp</h1>       </span>
          <span> <h1><a href="issues/newIssue.jsp">Add Issue</a><br></h1>       </span>
           <span> <h1><a href="issues/">View Issue</a><br></h1>       </span>
           <span> <h1><a href="projects"> Projects</a><br></h1>       </span>
             
             
               <span> <h3><a href="logout"> Log Out</a><br></h3>       </span>
 
</body>
</html>

