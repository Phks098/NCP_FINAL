package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.dao.Professor_Student_DAO;
import data.vo.Student_VO;

/**
 * Servlet implementation class Professor_Student
 */
@WebServlet("/Professor_Student")
public class Professor_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Professor_Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Gson gson = new Gson();
	
		
		String professor = null;
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("number")) {
				professor = cookie.getValue();
			}
		
		}
		System.out.println("교수 검색 모드 결과입니다."+professor);
		String keyword = request.getParameter("keyword");
		
		List<Student_VO> studentList = Professor_Student_DAO.getStudent(professor,keyword);
		List<Map<String,Object>> studentMap = new ArrayList<>();
		
		
		
		
		for(Student_VO std : studentList) {
			Map<String, Object> data = new HashMap<>();
			data.put("university_number", (String)std.getUniversity_number());
			data.put("name", (String)std.getName());
			data.put("major", (String)std.getMajor());
			data.put("grade",(String)std.getGrade());
			data.put("possfer", (String)std.getProfessor_number());
			data.put("sex",(String)std.getSex());
			studentMap.add(data);
		}
	
	
		
		
		String jsonData = gson.toJson(studentMap);
		response.getWriter().write(jsonData);
		
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
