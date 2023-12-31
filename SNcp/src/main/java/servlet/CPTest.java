package servlet;

import java.awt.SystemTray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.MyPage_DAO2;

@WebServlet("/CPTest")
public class CPTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CPTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String student_number = null;
	
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("number")) {
				student_number = cookie.getValue();
			}	
		}
		
		ArrayList<String> value = new ArrayList<String>();
		System.out.println("reTest");
		MyPage_DAO2 dao =new MyPage_DAO2();
		for (int i = 0; i < 35; i++) {
			value.add(request.getParameter("check_" + (i + 1)));
		}
		
		for (int i = 0; i < 35; i++) {
			System.out.println("지문 "+i+"번째: "+value.get(i));
		}
		dao.re_insert(value, student_number);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
