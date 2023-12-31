package data.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.Reco;
import data.RecommendationResult_Program;
import data.vo.Preference_Information_VO;
import data.vo.Recommendation_Result_VO;
import data.vo.Student_VO;

public class Student_DAO {
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
	
	public static List<Student_VO> getStudentForProf(String professor) {
		List<Student_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.student.searchStudentForProf", professor);

		return datum;
	}
	
	public static List<Preference_Information_VO> getPreferenceInformation() {
		List<Preference_Information_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.preference_information.selectAll");

		return datum;
	}
	//해당 학생의 원하는 조건을 가져온다 운영방식, 운영 기간, 등등
	public static Preference_Information_VO getPreferenceInformation(String university_number) {
		Preference_Information_VO data = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		Map<String, Object> parameter = new HashMap<>();

		parameter.put("university_number", university_number);
		
		//희망하는 직무 및 시작날짜와 끝 날짜 운영 방식에 대해서 값을 가져온다.
		data = session.selectOne("mapper.preference_information.selectOne", parameter);

		return data;
	}
	
	public static int insertPreferenceInformation(Preference_Information_VO preInfo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		int result = session.insert("mapper.preference_information.insertOne", preInfo);
		if (result > 0) {
			session.commit();
		}
		System.out.println(result);
		return result;
	}
	
	// 선호 정보를 업데이트를 해준다.
	public static int updatePreferenceInformation(Preference_Information_VO preferenceInformation) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		int result = session.update("mapper.preference_information.updateOne", preferenceInformation);
		if (result > 0) {
			session.commit();
		}
		
		return result;
	}

	public static Student_VO getStudent(String university_number) {
		Student_VO data = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		data = session.selectOne("mapper.student.selectOne", university_number);

		return data;
	}
	
	public static List<Reco> getReco(String university_number) {
		List<Reco> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.recommendation_result.getReco", university_number);

		return datum;
	}
	
	public static int deleteReco(String university_number) {
		int result = -1;
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		result = session.delete("mapper.recommendation_result.deleteReco", university_number);
		if(result > 0) {
			session.commit();
		}
		return result;
	}
	
	public static List<Recommendation_Result_VO> getRecommendationResult(String university_number) {
		List<Recommendation_Result_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		Map<String, Object> parameter = new HashMap<>();

		parameter.put("university_number", university_number);

		datum = session.selectList("mapper.recommendation_result.selectAll", parameter);

		return datum;
	}

	public static int insertRecommendedResult(List<Recommendation_Result_VO> results) {
		int result = -1;
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		Map<String, Object> parameter = new HashMap<>();

		parameter.put("list", results);
		
		result = session.insert("mapper.recommendation_result.insert", results);
		if (result > 0) {
			session.commit();
		}
		
		return result;
	}
	
	public static List<RecommendationResult_Program> getRecommendationResult_Program(String program_code) {
		List<RecommendationResult_Program> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		Map<String, Object> parameter = new HashMap<>();

		parameter.put("code", program_code);

		datum = session.selectList("mapper.recommendation_result.recoList", parameter);

		return datum;
	}
	
}
