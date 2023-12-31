package data.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.EducationSet;
import data.Integration_Score;
import data.Preparation_Level;
import data.vo.Career_test_VO;
import data.vo.Education_Result_VO;
import data.vo.Education_identity_test_VO;
import data.vo.Education_identity_test_score_VO;
import data.vo.Mypage_VO;
import data.vo.Professor_education_identity_test_VO;
import data.vo.Student_VO;

public class MyPage_DAO2 {

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
	
	public ArrayList<ArrayList<Mypage_VO>> getStudent_LevelAll(String professor) {
		List<Mypage_VO> data = new ArrayList<Mypage_VO>();
		ArrayList<Mypage_VO> leve = new ArrayList<Mypage_VO>();
		ArrayList<Mypage_VO> temp = new ArrayList<Mypage_VO>();
		ArrayList<ArrayList<Mypage_VO>> levelList = new ArrayList<ArrayList<Mypage_VO>>();
		
		
		
		
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		data = session.selectList("mapper.mypage.selectProfessor", professor);
		leve = (ArrayList<Mypage_VO>)data;
		int count = 1;
		int shar = 9;

		for (int i = 0; i < leve.size(); i++) {
			
			
			
			temp.add(leve.get(i));
			count++;
			if(leve.get(i).getPreparation_rank() == 0 ) {
				levelList.add(temp);
				temp = new ArrayList<Mypage_VO>();
				count = 1;
			}
			

			if (count == 9) {

				levelList.add(temp);
				temp = new ArrayList<Mypage_VO>();
				count = 1;
			}

		}

		return (ArrayList<ArrayList<Mypage_VO>>) levelList;
	}
	
	
	
	

	public void insert_Education_Identity_Test(ArrayList<String> test_result, String sutudent) {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		
		session.delete("mapper.education.delete_Education_identity_test", sutudent);
		session.commit();
		session.delete("mapper.Education_identity_test_score.delete",sutudent);
		session.commit();
		session.delete("mapper.education_result.delete",sutudent);
		session.commit();
		

		List<Education_identity_test_VO> list = new ArrayList<>();
		
		for(int i = 1; i<8; i++) {
			list.add(new Education_identity_test_VO(sutudent,i,Integer.parseInt(test_result.get((i-1))),1,"now"));
		}
		for(int i = 8; i<15; i++) {
			list.add(new Education_identity_test_VO(sutudent,i,Integer.parseInt(test_result.get(i-1)),2,"now"));
		}
		for(int i = 15; i<20; i++) {
			list.add(new Education_identity_test_VO(sutudent,i,Integer.parseInt(test_result.get(i-1)),3,"now"));
		}
		
		Map<String, Object> map = new HashMap();

		map.put("list", list);

		session.insert("mapper.education.insert_Education_identity_test", map);
		session.commit();
		EducationSet setEducation = new EducationSet();
		
		// �ٽ��Է��� ������ü�� �˻縦 �ٽ� ����ؼ� �������� �������� �ٽ� Ȯ�����ش�.
		setEducation.setEducation(sutudent);
		
		

	}
	

	public void re_insert(ArrayList<String> list, String student) {
		List<Mypage_VO> data = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
	
		session.delete("mapper.mypage.delete_Career_Test", student);
		session.commit();
		session.delete("mapper.mypage.delete_Capability_Matching_score", student);
		session.commit();
		session.delete("mapper.mypage.delete_Integration_Score", student);
		session.commit();
		session.delete("mapper.mypage.delete_Preparation_Level", student);
		session.commit();
		
		List<Career_test_VO> Career_test_VO_list = new ArrayList<>();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		for (int i = 0; i < 5; i++) {
			Career_test_VO_list.add(new Career_test_VO(student, i + 1, Integer.parseInt(list.get(i)), 1, "now()"));
		}

		for (int i = 5; i < 11; i++) {
			Career_test_VO_list.add(new Career_test_VO(student, i + 1, Integer.parseInt(list.get(i)), 2, "now()"));
		}

		for (int i = 11; i < 16; i++) {
			Career_test_VO_list.add(new Career_test_VO(student, i + 1, Integer.parseInt(list.get(i)), 3, "now()"));
		}

		for (int i = 16; i < 23; i++) {
			Career_test_VO_list.add(new Career_test_VO(student, i + 1, Integer.parseInt(list.get(i)), 4, "now()"));
		}

		for (int i = 23; i < 28; i++) {
			Career_test_VO_list.add(new Career_test_VO(student, i + 1, Integer.parseInt(list.get(i)), 5, "now()"));
		}
		for (int i = 28; i < 35; i++) {
			Career_test_VO_list.add(new Career_test_VO(student, i + 1, Integer.parseInt(list.get(i)), 6, "now()"));
		}

		Map<String, Object> map = new HashMap<>();
		map.put("list", Career_test_VO_list);

		session.insert("mapper.mypage.insert_Career_test", map);
		session.commit();
		
		Integration_Score integration_Score = new Integration_Score();
		Preparation_Level preparation_Level = new Preparation_Level();

		
		integration_Score.InsertInto_Integration_Score(student);
		preparation_Level.Leve(student);
		System.out.println("잘 너었당께");
	}

	
	
	
	
	
	public ArrayList<Mypage_VO> getStudent_Level(String university_number) {
		List<Mypage_VO> data = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		data = session.selectList("mapper.mypage.selectOne", university_number);

		return (ArrayList<Mypage_VO>) data;
	}

	

	public void getEducation_Result() {
		
	}
	
	
	public Student_VO getStudentInformation(String univer_number) {

		Student_VO data = new Student_VO();
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		data = session.selectOne("mapper.student.selectAll", univer_number);

		return data;
	}

	
	
	public ArrayList<Education_identity_test_VO> getEducation_identity_test(String univer_number) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<Education_identity_test_VO> list = new ArrayList<>();

		list = session.selectList("mapper.education.select_Education_identity_test", univer_number);

		return (ArrayList<Education_identity_test_VO>) list;
	}
	
	public ArrayList<ArrayList<Education_identity_test_score_VO>> getEducation_studentAll(String professor){
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<Education_identity_test_score_VO> list = new ArrayList<Education_identity_test_score_VO>();
		ArrayList<Education_identity_test_score_VO> temp = new ArrayList<Education_identity_test_score_VO>();
		ArrayList<ArrayList<Education_identity_test_score_VO>> getList = new ArrayList<ArrayList<Education_identity_test_score_VO>>();
		
		list = session.selectList("mapper.Education_identity_test_score.selectProfessor",professor);
		
		
		for(int i = 0; i<list.size(); i++) {
			
			
			
			
		}
		
		
		
		
		
		
		
		return null;
	}

	public ArrayList<Professor_education_identity_test_VO> getProfessor_education_identity_test_VO(
			String univer_number) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		List<Professor_education_identity_test_VO> list = new ArrayList();

		list = session.selectList("mapper.professor_education.select_professor_education_identity_test", univer_number);

		return (ArrayList<Professor_education_identity_test_VO>) list;
	}
	
	public void insertProfessor_education(List<Professor_education_identity_test_VO> list) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		
		session.insert("mapper.professor_education.insertAll",map);
		session.commit();
		
	}
	
	public void deleteProfessor_Education(String univer) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		session.insert("mapper.professor_education.delete",univer);
		session.commit();
	}
	
	
	
	
	public int insertEducation_identity_test_score(ArrayList<Education_identity_test_score_VO> list) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		Map<String,Object> map = new HashMap();
		map.put("list", list);
		int result = session.insert("mapper.Education_identity_test_score.insert", map);
		session.commit();
		return result;
	}
	
	
	
	
	public int insertResult_Education(Education_Result_VO data) {
		
		int result = 0;
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		result = session.insert("mapper.education_result.insert",data);
		session.commit();
		
		return result;
		
	}
	
	
	
	
	

}
