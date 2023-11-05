package servlet;

import java.io.IOException;
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
import data.dao.Program_DAO;
import data.dao.Student_DAO;
import data.utils.CategoryUtils;
import data.vo.Preparation_Level_VO;
import data.vo.Program_Information_VO;
import data.vo.Student_VO;
import rlogic.Rlogic;

@WebServlet("/studentpage")
public class StudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_number = null;
		List<Preparation_Level_VO> preLevel = null;

		student_number = "201511245";

		Rlogic rLogic = new Rlogic();
		List<List<Reco>> results = rLogic.getReco(student_number);
		Student_VO student = Student_DAO.getStudent(student_number);
		student.setMajor(CategoryUtils.getMajorName(student.getMajor_number()));

		preLevel = Preparation_Level_DAO.selectAll(student_number);

		request.setAttribute("student", student);
		request.setAttribute("results", results);
		request.setAttribute("preLevels", preLevel);

		request.setAttribute("ncsList", CategoryUtils.ncsList);
		request.setAttribute("operatingMethodList", CategoryUtils.operatingMethodList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("StudentPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
