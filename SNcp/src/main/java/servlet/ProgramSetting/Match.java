package servlet.ProgramSetting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.dao.AdminMode_DAO;
import data.vo.Matching_criteria_VO;

@WebServlet("/Match")
public class Match extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminMode_DAO dao = new AdminMode_DAO();
		Gson gson = new Gson();
		String[] setMatch = request.getParameterValues("setMatch");
		dao.Update_Matching(setMatch);

		ArrayList<Matching_criteria_VO> matchList = dao.getAll_Matching_criteria_VO();
		List<Map<String, Object>> data = new ArrayList<>();

		for (Matching_criteria_VO match : matchList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("capability_number", match.getCapability_number());
			map.put("category_number", match.getCategory_number());
			map.put("matching_rate", match.getMatching_rate());
			data.add(map);

		}

		String jsonData = gson.toJson(data);
		response.getWriter().write(jsonData);

	}

}
