package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
public class Preparation_Level {// 매칭후 결과 값이다.
	
	Connection con;
	Statement stmt;
	ResultSet rs;

	String Driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://211.59.155.146:3306/ncp";
	String id = "root1";
	String password = "root";
	
	String university_number;   //학번
	int  capability_category;   //역량 영역
	float preparation_degree;   //준비도
	String preparation_level;   //준비 수준
	int preparation_rank;       //준비도 순위
	
	// 해당 학번의 학생의 8가지의 역량 점수 출력해준다.
	public void Leve(String university_number){
		
		ArrayList<Matching_criteria> list = new ArrayList<Matching_criteria>(); // 매칭 비율
		float[] total_matching = new float[8];
		float[]	original_score = {(float)5.0,(float)5.0,(float)5.0,(float)6.0,(float) 6.0,(float)7.0};
		Diagnosis_Criteria test = new Diagnosis_Criteria();
		Perset_state[]  ss = new Perset_state[8];
		int rang[] = {1,1,1,1,1,1,1,1};
		
		
		try {
			
			con = DriverManager.getConnection(url,id,password);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select i.university_number, i.integrated_score,m.Matching_rate, m.capability_number, m.category_number from integration_score as i "
					+ " inner join matching_criteria as m "
					+ " on i.test_category = m.category_number "
					+ " where i.university_number = '"+university_number+"' order by m.capability_number, m.category_number; ");
			
			while(rs.next()) {
				
				list.add(new Matching_criteria(rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5)));
				
			}
			int cateNum = 0;
			for(int i = 0; i<list.size(); i++) {
				if(cateNum+1 == list.get(i).category_number) {
					total_matching[cateNum] += Math.round(((list.get(i).category_total*original_score[list.get(i).category_number2-1]) * ( list.get(i).matching))*10)/1000.0;
					
					
				}else {
					++cateNum;
					total_matching[cateNum] +=Math.round(((list.get(i).category_total*original_score[list.get(i).category_number2-1]) * ( list.get(i).matching))*10)/1000.0 ;
				}	
			}
			
			
			for(int i = 0; i<total_matching.length; i++) {
				total_matching[i] = (float) ( Math.round(total_matching[i]*100)/100.0);
				
			}
			
			for(int i = 0; i<total_matching.length; i++) {
				System.out.println(i+"코드 역량 번호: "+total_matching[i]);
				String sql2 = "insert into Capability_Matching_Score values ('"+university_number+"',"+(i+1)+","+total_matching[i]+")";
				System.out.println(sql2);
				
				stmt.execute(sql2);
			}
			
			
			for(int i =0; i<total_matching.length; i++) {
				
				ss[i]=test.Check_Level(i+1, total_matching[i]);
			}
			
			
			
			
			
			for(int i = 0; i<rang.length; i++) {
				for(int j=i; j<rang.length; j++) {
					if(ss[i].persent<ss[j].persent) {
						++rang[i];
					}else {
						++rang[j];
					}
				}
			}
			
			
			
			
			for(int i =0; i<ss.length; i++) {
				rang[i]= rang[i]-1;
				System.out.println("영역 번호: "+(i+1)+" 준비 수준: "+ss[i].state+"  준비도: "+ss[i].persent+"%  순위: "+rang[i]);
			}
			
			
			
			String sql = "insert into Preparation_Level values "
					+ "('"+university_number+"',"+1+","+ss[0].persent+",'"+ss[0].state+"',"+(rang[0])+"),"
					+ "('"+university_number+"',"+2+","+ss[1].persent+",'"+ss[1].state+"',"+(rang[1])+"),"
					+ "('"+university_number+"',"+3+","+ss[2].persent+",'"+ss[2].state+"',"+(rang[2])+"),"
					+ "('"+university_number+"',"+4+","+ss[3].persent+",'"+ss[3].state+"',"+(rang[3])+"),"
					+ "('"+university_number+"',"+5+","+ss[4].persent+",'"+ss[4].state+"',"+(rang[4])+"),"
					+ "('"+university_number+"',"+6+","+ss[5].persent+",'"+ss[5].state+"',"+(rang[5])+"),"
					+ "('"+university_number+"',"+7+","+ss[6].persent+",'"+ss[6].state+"',"+(rang[6])+"),"
					+ "('"+university_number+"',"+8+","+ss[7].persent+",'"+ss[7].state+"',"+(rang[7])+");";
			
			System.out.println(sql);
			
			stmt.execute(sql);
			//매칭값 출력
			//평균 통합 점수를 가지고와서 매칭한 결과를 정리해서 저장해준다.
			//매칭     테이블   1. 8가지 역량, 2.6가지 역량, 3. 20%
			//통합 점수 테이블   1. 학번
			// 매칭후 점수
			
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}