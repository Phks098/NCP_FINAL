package data.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import data.vo.Capability_category_VO;
import data.vo.College_Information_VO;
import data.vo.Department_Information_VO;
import data.vo.Major_Information_VO;
import data.vo.NCS_Part_VO;
import data.vo.Operating_State_VO;
import data.vo.Program_Operating_Method_VO;
import data.vo.Program_Operating_Type_VO;
import data.vo.Student_Sex_VO;

public class Category_DAO {
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
	
	// 8개의 역량 카테고리
	public static List<Capability_category_VO> capabilityCategorySelectAll(){
		
		List<Capability_category_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.capability_category.selectAll");
		
		
		return datum;
	}
	
	public static List<Major_Information_VO> majorSelectAll() {
		List<Major_Information_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.major_information.selectAll");

		return datum;
	}
	
	// 성별
	public static List<Student_Sex_VO> sexSelectAll() {
		List<Student_Sex_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.student_sex.selectAll");

		return datum;
	}
	
	// 연계 정보
	public static List<NCS_Part_VO> ncsSelectAll(){
		List<NCS_Part_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.ncs_part.selectAll");

		return datum;
	}
	
	// 비교과 프로그램 운영 유형
	public static List<Program_Operating_Type_VO> operatingTypeSelectAll(){
		List<Program_Operating_Type_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.program_operating_type.selectAll");

		return datum;
	}
	
	// 비교과 프로그램 운영 상태
	public static List<Operating_State_VO> operatingStateSelectAll(){
		List<Operating_State_VO> datum = null;
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		datum = session.selectList("mapper.operating_state.selectAll");
		
		return datum;
	}
	
	// 비교과 프로그램 운영 방식
	public static List<Program_Operating_Method_VO> operatingMethodSelectAll(){
		List<Program_Operating_Method_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.program_operating_method.selectAll");

		return datum;
	}
	
	// 단과 대학
	public static List<College_Information_VO> collegeInformationSelectAll(){
		List<College_Information_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.college_information.selectAll");

		return datum;
	}
	
	// 학부 정보
	public static List<Department_Information_VO> departmentInformationSelectAll(){
		List<Department_Information_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.department_information.selectAll");

		return datum;
	}
	
	// 학과 정보
	public static List<Major_Information_VO> majorInformationSelectAll(){
		List<Major_Information_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.major_information.selectAll");

		return datum;
	}
}
