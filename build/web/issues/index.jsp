<%-- 
    Document   : register_2
    Created on : 15-Feb-2021, 11:59:36 am
    Author     : Lenovo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%// if(session.getAttribute("username")== null){
     //response.sendRedirect("Login.jsp");
   
   //  }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Success Page</title>
</head>
<body bgcolor="orange">
           <a><br>Welcome Admin!!!!</br></a>
           <a><br>Welcome ${username}!!!!</br></a>
         <span><%=request.getAttribute("username")%>         </span>
         <span> Session name<%=request.getAttribute("s_name")%>         </span>
         <span> <h1>This is the Page</h1>       </span>
           <span> <h1><a href="view">Issues</a><br></h1>       </span>
 
</body>
</html>
