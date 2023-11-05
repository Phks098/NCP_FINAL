package data.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Student_Code_VO;

public class Student_DAO {
	
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
	
	public Student_Code_VO getStdent_Code(String student){
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		Student_Code_VO data = new Student_Code_VO();
		data = session.selectOne("mapper.student_code.select",student);
		
		
		
		return data;
	}
	
	
	

}
