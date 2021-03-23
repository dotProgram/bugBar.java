<%-- 
    Document   : Register_1
    Created on : 15-Feb-2021, 10:30:38 am
    Author     : Lenovo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Registration Form</title>
</head>
<!-- comment 
<body  bgcolor="steelblue">
<h1> Register Form</h1>
<form action="register" method="post">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contact" /></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>
</body>
  -->
  <body  <body bgcolor="lightblue">
    <div align="center" style='margin-top: 15%; background-color: white;'">

    <h1 align="center">Add User</h1>
    <form action="../RegisterServlet1" method="post">
    <input type="hidden" id="custId" name="type" value="user">
 <table border=0 width=30% height=20%>
          <tr>
              <th>First  Name:</th><th><input type="text" name="firstN"/></th><th></th>
          <tr></tr>
          <tr>
              <th> Last Name:</th><th><input type="text" name="lName"/></th><th></th>
          <tr></tr><!-- comment -->
          <tr>
              <th>userid</th><th><input type="text" name="userid"/></th><th></th>
          <tr></tr><!-- comment -->
          <tr>
              <th>Set Password:</th><th><input type="password" name="password"/></th><th></th>
          <tr></tr><!-- comment -->
          <tr>
              <th>Confirm Password:</th><th><input type="password" name="password"/></th><th></th>
          <tr></tr>
          <tr>
              <th> Email Id:</th><th><input type="email" name="email" /></th><th></th>
          <tr></tr><!-- comment --><tr>
              <th>Phone :</th><th><input type="text" name="phno" /></th><th></th>
          <tr></tr>
          
          <tr>
              <th>Language:</th><th>Language: <select name="language">
            <option>Hindi</option>
            <option>English</option>
            <option>French</option>
        </select> </th><th></th>
          <tr>
          
          <tr>
              <th></th><th><input type="submit" value="Submit"/>  </th><th></th>
          <tr></tr>
 
           </table>     
       

        
        
 
    </form> </div>
<br><br><br>

</body>

</html>