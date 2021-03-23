package demotest;
 

 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.annotation.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class guru_register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
        @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
                PrintWriter out = response.getWriter( );
                //JUST TO DISPLAY DATA
                request.setAttribute("first_name",first_name);
                request.getAttribute("first_name").toString();
              
if(first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() || 
				password.isEmpty() || address.isEmpty() || contact.isEmpty())
		{
			//RequestDispatcher req = request.getRequestDispatcher("Register_1.jsp");
			//req.include(request, response);
                       // out.println("Invalid Entries") ;
			response.sendRedirect("Register_1.jsp");
			 out.println("This is the Test") ;
                
        out.println("<strong>" + first_name + "</strong>  <br /><strong>" + last_name + "</strong>  <br /><strong>" + username + "</strong> : <br /><strong>" + password + "</strong> : <br />"
                );
		}
		else
		{
			RequestDispatcher req = request.getRequestDispatcher("register_2.jsp");
			req.forward(request, response);
		}
	}
       // out.println("<br />");

    }//while
                
                
		 
 
