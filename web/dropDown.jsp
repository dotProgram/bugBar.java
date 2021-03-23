<%@ page import="java.sql.*" %>
<% ResultSet resultset =null;%>

<HTML>
<HEAD>
    <TITLE>Select element drop down box</TITLE>
</HEAD>

<BODY BGCOLOR=orange>

<%
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
     //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", ""); 
       Statement statement = connection.createStatement() ;

       resultset = statement.executeQuery("select * from user") ;
       String first_name, last_name, concat;
%>

<center> <br>
    <h1> Drop down box or select element</h1>
        <select>
        <%  while(resultset.next()){ 
        first_name = resultset.getString(2);
        last_name = resultset.getString(3);
        concat = first_name + " "+ last_name;
       // resultset.getString(6)
        %>
            <option><%= concat %></option>
        <% } %>
        </select>
         <br>  <select>Email
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(6)%></option>
        <% } %>
        </select>
         <select> <br>  
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(4)%></option>
        <% } %>
        </select>
</center>


<%
//**Should I input the codes here?**
 connection.close();  
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

</BODY>
</HTML>