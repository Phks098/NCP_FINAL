import java.util.List;
import java.util.Map;

import data.vo.Preparation_Level_VO;
import rlogic.Recommendation_Program;
import rlogic.Rlogic;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rlogic logic = new Rlogic();
		String code = null;
		List<Preparation_Level_VO> preLevel = null;
		Recommendation_Program recoProgram = new Recommendation_Program();
		List<Map<String, String>> datum = recoProgram.getPrettyRecommendation("2");
	
		System.out.println(datum);
		
	}

}
