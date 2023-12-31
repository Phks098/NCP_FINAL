package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Reco;
import data.dao.Preparation_Level_DAO;
import data.dao.Student_DAO;
import data.utils.CategoryUtils;
import data.vo.Preparation_Level_VO;
import data.vo.Student_VO;
import rlogic.Rlogic;

@WebServlet("/mypage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_number = null;
		String power = null;
		List<Preparation_Level_VO> preLevel = null;
		List<Preparation_Level_VO> preLevelDesc = null;

		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("number")) {
				student_number = cookie.getValue();
			}
			if (cookie.getName().equals("power")) {
				power = cookie.getValue();
			}
		}
		
		System.out.println(student_number+"로그인확인");
		if (power.equals("2")) {
			student_number = request.getParameter("student");
			if( request.getParameter("student") ==null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('잘못된 정보 입니다.'); location.href='index.jsp';</script>");
				out.flush();
				
			}
		}

		Rlogic rLogic = new Rlogic();
		List<List<Reco>> results = rLogic.getReco(student_number);
		Student_VO student = Student_DAO.getStudent(student_number);
		student.setMajor(CategoryUtils.getMajorName(student.getMajor_number()));
		System.out.println("");
		for(int i = 0; i< results.size(); i++) {
			System.out.println(i+"번째 역량 비교과 추천 리스트");
			for(int j = 0; j<results.get(i).size(); j++) {
				System.out.println(results.get(i).get(j).getCode());
			}
		}
		
	
		
		preLevel = Preparation_Level_DAO.selectAll(student_number);
		preLevelDesc = Preparation_Level_DAO.selectAllDesc(student_number);

		for(Preparation_Level_VO set : preLevel) {
			set.setCapability_category(CategoryUtils.getCapabilityCategoryName(set.getCapability_category()));
		}

		request.setAttribute("student", student);
		request.setAttribute("results", results);
		request.setAttribute("preLevels", preLevel);
		request.setAttribute("preLevelsDesc", preLevelDesc);

		request.setAttribute("ncsList", CategoryUtils.ncsList);// 직무 관련해서 가져온다.
		request.setAttribute("operatingMethodList", CategoryUtils.operatingMethodList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("MyPage.jsp");
		dispatcher.forward(request, response);
	}

}
