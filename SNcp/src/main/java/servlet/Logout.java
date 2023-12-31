package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		System.out.println("쿠키 제거되었습니다.");
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);

                // 쿠키 경로를 설정합니다. (로그인 시 설정한 경로와 동일해야 함)
                cookie.setPath("/Security_NCP");

                // 응답에 쿠키를 추가하여 클라이언트로 전송합니다.
                response.addCookie(cookie);
			}
		}
		
		if(cookies ==null) {
			
			System.out.println("모두 제거 완료");
			
		}
		else {
			
			System.out.println("제거 못함");
			
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getValue());
			}
			
		}

		response.sendRedirect("index.jsp");
		// RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		// dispatcher.forward(request, response);

	}

}
