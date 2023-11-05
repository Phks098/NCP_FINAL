package data;

import java.util.ArrayList;
import java.util.List;

import data.dao.Career_development_preparationDAO;
import data.vo.Career_test_VO;
import data.vo.Diagnosis_criteria_VO;
import data.vo.Matching_criteria_VO;
import data.vo.Professor_career_evaluation_VO;
import data.vo.Professor_weight_VO;

public class Career_development_preparation {

	// 매칭 비율을 가져온다
	List<Matching_criteria_VO> match = Career_development_preparationDAO.getMatching_criteria();
	// 지도교수 가중치값
	List<Professor_weight_VO> weight = Career_development_preparationDAO.getProfessor_weight();
	// 준비수준진단 기준
	List<Diagnosis_criteria_VO> diagnosis = null;

	// 진로개발준비도 검사
	List<Career_test_VO> career = null;

	// 지도교수 평가지
	List<Professor_career_evaluation_VO> career_Evalution = null;

	// careerTest 값을 가져와서 분류를 하고 저장한다.
	Career_development_preparation(List<String> Careervalue, String university_number) {
		setCategoryTest(Careervalue,university_number);
		
		// 학생이 검사를 받았든 안받았든 삭제한다.
		Career_development_preparationDAO.deleteCareer(university_number);
		
		
		//삭제한후 다시 산입한다.
		
	}

	// 해당 학생의 학번
	private void setCategoryTest(List<String> test, String university_number) {
		/*
		 * 1.자기이해 5개 2.전공직업 6개 3.진로결정 5개 4.의사결정 6개 5.관계활용 6개 6.진로준비도 7개
		 */
		career = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			career.add(new Career_test_VO(university_number, i + 1, Integer.parseInt(test.get(i)), 1, "now()"));
		}

		for (int i = 5; i < 11; i++) {
			career.add(new Career_test_VO(university_number, i + 1, Integer.parseInt(test.get(i)), 2, "now()"));
		}

		for (int i = 11; i < 16; i++) {
			career.add(new Career_test_VO(university_number, i + 1, Integer.parseInt(test.get(i)), 3, "now()"));
		}

		for (int i = 16; i < 23; i++) {
			career.add(new Career_test_VO(university_number, i + 1, Integer.parseInt(test.get(i)), 4, "now()"));
		}

		for (int i = 23; i < 28; i++) {
			career.add(new Career_test_VO(university_number, i + 1, Integer.parseInt(test.get(i)), 5, "now()"));
		}
		for (int i = 28; i < 35; i++) {
			career.add(new Career_test_VO(university_number, i + 1, Integer.parseInt(test.get(i)), 6, "now()"));
		}

	}

}
