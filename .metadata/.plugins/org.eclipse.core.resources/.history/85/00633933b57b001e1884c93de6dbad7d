package data.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.MyPage_DAO;
import data.dao.MyPage_DAO2;
import data.vo.Student_VO;

/**
 * Servlet implementation class Education_Identity_Test_Servlet
 */
@WebServlet("/Education_Identity_Test_Servlet")
public class Education_Identity_Test_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Education_Identity_Test_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String univer = request.getParameter("student");
		String action = request.getParameter("action");
		
		univer ="201811013";
		
		MyPage_DAO2 dao2 = new MyPage_DAO2();
		
		
		
		Student_VO st = dao2.getStudentInformation(univer);
		
		String page = "Education_Identity_Test_page.jsp";
		if(action == null) {
			 page = "Education_Identity_Test_page.jsp";
			 request.setAttribute("student", st);
			 
		}
		
		
		
		//커리어넷 검사 제출시 다시 결과를 계산해서 산출해준다.
		
		else if(action.equals("reTest")) {
			System.out.println(univer+"학생의 진로개발준비도검사 시작했습니다.");
			ArrayList<String> value = new ArrayList();
			System.out.println("reTest");
			
			System.out.println(univer);
			for (int i = 0; i < 35; i++) {
				value.add(request.getParameter("check_" + (i + 1)));
			}
			dao2.re_insert(value, univer);
			
			page = "http://211.59.155.146:8080/index.jsp";
			
		}
		
		
		
		//진로정체감 검사 제출시 다시 결과를 계산해준다.
		else if(action.equals("Education_Test_Set")) {
			System.out.println("Education_Test_Set_start");
			ArrayList<String> value = new ArrayList();
			
			
			
			System.out.println(univer);
			for (int i = 0; i < 19; i++) {
				value.add(request.getParameter("check_" + (i + 1)));
			}
			// value = 진로정체감 선택지 결과를 저장하는 변수이다.
			
			dao2.insert_Education_Identity_Test(value,univer);
			
		
			
			page = "http://211.59.155.146:8080/index.jsp";
		}
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
