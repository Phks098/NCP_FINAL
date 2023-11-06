package servlet.ProgramSetting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.MyPage_DAO;
import data.dao.Student_DAO;
import data.utils.CategoryUtils;
import data.vo.Student_VO;


@WebServlet("/Professr_Career")
public class Professr_Career extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Professr_Career() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String university_number = request.getParameter("university_number");
		String professor = request.getParameter("professor");
		professor = "3";
		Student_VO student = Student_DAO.getStudent(university_number);
		student.setMajor(CategoryUtils.getMajorName(student.getMajor_number()));
		
		request.setAttribute("professor", professor);
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Career_Development_Preparation_Evaluation_Page.jsp");
		dispatcher.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
