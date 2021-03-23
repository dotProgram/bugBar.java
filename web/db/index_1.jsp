<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
    
    <h1>Register  Database Data</h1>
    <form action="register1" method="post">
 <table border=1 width=50% height=50%>
          <tr>
              <th>First  Name:</th><th><input type="text" name="firstN"/></th><th>lName</th>
          <tr></tr>
          <tr>
              <th> Last Name:</th><th><input type="text" name="lName"/></th><th>lName</th>
          <tr></tr><!-- comment -->
          <tr>
              <th>userid</th><th><input type="text" name="userid"/></th><th>lName</th>
          <tr></tr><!-- comment -->
          <tr>
              <th>Password:</th><th><input type="password" name="password"/></th><th>lName</th>
          <tr></tr><!-- comment -->
          <tr>
              <th> Email Id:</th><th><input type="email" name="email" /></th><th>lName</th>
          <tr></tr><!-- comment --><tr>
              <th>Phone :</th><th><input type="text" name="phno" /></th><th>lName</th>
          <tr></tr>
          
          <tr>
              <th>Language:</th><th>Language: <select name="language">
            <option>Hindi</option>
            <option>English</option>
            <option>French</option>
        </select> </th><th><input type="submit" value="Submit"/></th>
          <tr></tr>
          
          
 
           </table>     
       

        
        
 
    </form>
<br><br><br>
<h1>Request Database Data</h1>
 <form action="display" method="post">
 
       
        <input type="submit" value="Submit"/>
 
    </form>
</body>
</html>

