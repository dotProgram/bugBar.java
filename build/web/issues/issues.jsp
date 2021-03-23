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
        
         
         <span> <h1>This is the Add Issues Page</h1>       </span>
           <span> <h1><a href="newIssue.jsp">Add Project</a><br></h1>       </span>
           
           <div align="center" >    Import Servlet <br> <iframe style="width: 50%; height: 800px; overflow: no-display;"  src="displayIssues" title="W3Schools Free Online Web Tutorials"></iframe>
           <%@ page import="issue.displayIssues" %>
     
           
           </div>
 
</body>
</html>
