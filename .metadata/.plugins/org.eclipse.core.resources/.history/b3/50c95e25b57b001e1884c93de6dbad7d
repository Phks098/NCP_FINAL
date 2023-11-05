package data.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Education_Reasult_Score_VO;
import data.vo.Education_Result_VO;

public class Education_Result_Get_DAO {
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
	
	
	public ArrayList<Education_Reasult_Score_VO> getEducation(String student) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		List<Education_Reasult_Score_VO> list = new ArrayList<Education_Reasult_Score_VO>();
		
		
		list = session.selectList("mapper.education_result_get.select",student);	
		return (ArrayList<Education_Reasult_Score_VO>) list;
	}
	
	public Education_Result_VO getCheckEducation(String student) {
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		Education_Result_VO check = session.selectOne("mapper.education_result.select",student);
		
		
		return check;
	}
}
