package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.dao.AdminMode_DAO;
import data.vo.Diagnosis_criteria_VO;
import data.vo.Matching_criteria_VO;
import data.vo.Professor_weight_VO;



@WebServlet("/AdminMode")
public class AdminMode_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminMode_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminMode_DAO dao = new AdminMode_DAO();
		ArrayList<Professor_weight_VO> weight = dao.getAll_Professor_weight_VO();
		ArrayList<Matching_criteria_VO> match = dao.getAll_Matching_criteria_VO();
		ArrayList<Diagnosis_criteria_VO> level = dao.getAll_Diagnosis_criteria_VO(); 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Map<String,Object> data = new HashMap<String,Object>();
		
		data.put("weight", weight);
		data.put("match", match);
		data.put("leve", level);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(data);
		response.getWriter().write(jsonData);
		request.getHeader(jsonData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}