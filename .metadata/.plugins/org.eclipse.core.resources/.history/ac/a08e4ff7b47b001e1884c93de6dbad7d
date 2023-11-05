package data.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Professor_career_evaluation_VO;
import data.vo.Student_Code_VO;
import data.vo.Student_VO;

public class Scholar_Evaluation_DAO {

	private static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "data/mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}

	public ArrayList<Student_VO> getStuduent_AllList(String professor) {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		List<Student_VO> list = new ArrayList<Student_VO>();

		list = session.selectList("mapper.student.selectAll_pro", professor);

		return (ArrayList<Student_VO>) list;
	}

	private Connection getConnection() throws Exception {

		String url = "jdbc:mysql://localhost:3306/ncp";
		String id = "root";
		String pw = "1234";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, id, pw);
		return con;

	}

//	public void SetEvaluation(ArrayList list, String univertion_number) {
//
//		String sql = null;
//
//		try {
//			Connection con = getConnection();
//			Statement stmt = con.createStatement();
//			for (int i = 0; i < list.size(); i++) {
//				sql = "update Professor_Career_Evaluation set " + "evaluation_grade = " + list.get(i)
//						+ " where test_category = " + (i + 1) + " and university_number = '" + univertion_number + "'";
//				stmt.executeUpdate(sql);
//			}
//
//			stmt.close();
//			con.close();
//
//		} catch (Exception e) {
//
//		}
//	}

	// 진로개발준비도 검사를 걸러주는 함수
	public void SetEvaluation(ArrayList<String> list, String univertion_number) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		// 해당 학생이 검사가 처음이라면 그냥 입력한다.
		if (session.selectList("mapper.scholar.select",univertion_number) == null) {
			insertCareer_Evaluation(univertion_number, list);
		}
		// 아니라면 기존 평가내용을 전부 삭제한후 다시 입력한다.
		else {
			deleteCareer_Evaluation(univertion_number);
			insertCareer_Evaluation(univertion_number, list);
		}

	}

	// 진로개발준비도검사 업데이트하기
	public void deleteCareer_Evaluation(String student) {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		session.delete("mapper.scholar.delete",student);
		session.commit();

	}

	// 진로개발준비도 평가를 입력하는 함수
	public void insertCareer_Evaluation(String student,ArrayList<String> checkList) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		
		Student_Code_VO code = new Student_Code_VO();
		Student_DAO da = new Student_DAO();
		code = da.getStdent_Code(student);
		
		
		List<Professor_career_evaluation_VO> list = new ArrayList<>();
		
		
		for(int i = 0; i<checkList.size(); i++) {
			list.add(new Professor_career_evaluation_VO(code.getUniversity_number(),(i+1),Integer.parseInt(checkList.get(i)),code.getProfessor_number(),"now()"));
		}
		
		
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		
		session.insert("mapper.scholar.insert_Evaluation",map);
		session.commit();
		
		
		
	}

}
