package data.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Mypage_VO;
import data.vo.Student_VO;

public class MyPage_DAO {
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

	public static ArrayList<Mypage_VO> getStudent_Level(String university_number) {
		List<Mypage_VO> data = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		data = session.selectList("mapper.mypage.selectOne", university_number);

		return (ArrayList<Mypage_VO>) data;
	}
	
	
	

	public static Student_VO getStudentInformation(String univer_number) {

		Student_VO data = null;
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		data = session.selectOne("mapper.student.selectAll", univer_number);

		return data;
	}

}
