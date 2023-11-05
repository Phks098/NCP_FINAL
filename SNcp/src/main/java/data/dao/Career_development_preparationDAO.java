package data.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Career_test_VO;
import data.vo.Diagnosis_criteria_VO;
import data.vo.Matching_criteria_VO;
import data.vo.Professor_career_evaluation_VO;
import data.vo.Professor_weight_VO;

public class Career_development_preparationDAO {
	private static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {

		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	// 매칭 비율
	public static List<Matching_criteria_VO> getMatching_criteria() {
		return null;
	}
	// 지도교수 가중치
	public static List<Professor_weight_VO> getProfessor_weight(){
		
		return null;
	}
	//준비기준 가져온다.
	public static List<Diagnosis_criteria_VO> getDiagnosisCriteria(){
		return null;
	}
	
	
	
	// 진로개발준비도 평가 결과
	public List<Professor_career_evaluation_VO> getProfessorCarrerEvaluation(String university_number){
		return null;
	}
	//진로개발준비도검사 저장
	public static void deleteCareer(String student) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		session.delete("mapper.mypage.delete_Career_Test", student);
		session.commit();
			
	}
	public void insertCaeer(String student, List<Career_test_VO> list) {
		
	}
	
	
	
	

}
