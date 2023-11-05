package servlet.ProgramSetting;

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

@WebServlet("/Level")
public class Level extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Level() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminMode_DAO dao = new AdminMode_DAO();
		Gson gson = new Gson();

		String[] level = request.getParameterValues("setLevel");
		dao.Update_Leve(level);

		ArrayList<Diagnosis_criteria_VO> levelList = dao.getAll_Diagnosis_criteria_VO();
		ArrayList<Map<String, Object>> data = new ArrayList<>();

		for (Diagnosis_criteria_VO diagnosis : levelList) {
			Map<String, Object> map = new HashMap<>();
			map.put("capability_category", diagnosis.getCapability_category());
			map.put("high_max", diagnosis.getHigh_max());
			map.put("high_min", diagnosis.getHigh_min());
			map.put("normal_max", diagnosis.getNormal_max());
			map.put("normal_min", diagnosis.getNormal_min());
			map.put("low_max", diagnosis.getLow_max());
			map.put("low_min", diagnosis.getLow_min());
			data.add(map);
		}
		String jsonData = gson.toJson(data);
		response.getWriter().write(jsonData);

	}

}
