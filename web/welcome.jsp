<%-- 
    Document   : register_2
    Created on : 15-Feb-2021, 11:59:36 am
    Author     : Lenovo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if(session.getAttribute("admin")== null){
     response.sendRedirect("Login.jsp");

     }


   System.out.println("session.getAttribute(user_name); "+session.getAttribute("user_name"));
   out.println("session.getAttribute(user_name); "+session.getAttribute("user_name"));
   out.println("session.getAttribute(id); "+session.getAttribute("id"));
   //String I_d = (String)session.getAttribute("id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Success Page</title>
</head>
<body bgcolor="lightyellow">
           <a><br>Welcome ADMIN!!!!</br></a>
           <a><br>Welcome ${username}!!!!</br></a>
         <span><%= session.getAttribute("user_name") %>         </span>
          <span>Logged Id From Session Variable :  <%= session.getAttribute("id") %>         </span><br>
           <span>Logged User Id From Session Variable : <%= session.getAttribute("user_name") %>         </span><br>
         <span> Session name<%= session.getAttribute("s_name") %>         </span>
         
           <br><span>Logged Id  :  <%= session.getAttribute("id") %>         </span><br>
         
         
         <span> <h1>This is the Admin Page</h1>       </span>
          <span> <h1><a href="issues/newIssue.jsp">Add Issue</a><br></h1>       </span>
           <span> <h1><a href="issues/">View Issue</a><br></h1>       </span>
           <span> <h1><a href="projects"> Projects</a><br></h1>       </span>
              <span> <h1><a href="display"> View Members</a><br></h1>       </span>
              <span> <h1><a href="db/"> Add Members</a><br></h1>       </span>
              <span> <h1><a href="admin/"> Admin</a><br></h1>       </span>
               <span> <h3><a href="logout"> Log Out</a><br></h3>       </span>
 
</body>
</html>
