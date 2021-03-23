<%-- 
    Document   : register_2
    Created on : 15-Feb-2021, 11:59:36 am
    Author     : Lenovo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if(request.getAttribute("first_name")== null){
     response.sendRedirect("Register_1.jsp");
   
     }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Success Page</title>
</head>
<body  bgcolor="steelblue">
           <a><b>Registration Success</b></a>
</body>
</html>
