package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CUKI")
public class CUKI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CUKI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String power = null; 
		String student_number= null;
		
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("number")) {
				student_number = cookie.getValue();
			}
			if (cookie.getName().equals("power")) {
				power = cookie.getValue();
			}
		}
		if(power.equals("1")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_mode.jsp");
		}
		if(power.equals("2")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_mode.jsp");
		}
		if(power.equals("3")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_mode.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
