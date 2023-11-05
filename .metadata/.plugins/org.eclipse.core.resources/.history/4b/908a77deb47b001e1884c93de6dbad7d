package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Integration_Score {
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String Driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://211.59.155.146:3306/ncp" ;
	String id = "root1";
	String password = "root";
	
	
	String university_number;    //학번
	int test_category;           //분류번호 1.이해,2.
	float category_everage;  // 해당 분류 번호의 평균
	float integrated_score;  // 통합점수
	
	// 해당 지도하는 교수님의 진로수준 정보를 가져와서 가중치값을 대입해서 계산해준다.
	
	public Integration_Score(){
		       
	}
	
	Integration_Score(String university_number,int test_category,float category_everage, float integrated_score){
		this.university_number = university_number;
		this.test_category =test_category;
		this.category_everage = category_everage;
		this.integrated_score = integrated_score; 
	}
	
	public void InsertInto_Integration_Score(String university_number){
		// 매개 변수 == 통합 점수를 계산해줄 학생의 학번
		
		float[] professor_weight = new float[6];
		float[] avg_test_grade = new float[6];
		float[] integrated_score_all = new float[6];
		
		try {
			con = DriverManager.getConnection(url,id,password);
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select w.weight from Professor_Career_Evaluation as p "
					+ "inner join professor_weight as w "
					+ "on p.evaluation_grade = w.evaluation_grade where university_number ='"+university_number+"'"); 
			
			//1~6번 역량의 담당교수 가중치값을 professor_weight 배열에 집어 넣는다.
			
			int count = 0;
			
			while(rs.next()) {
				professor_weight[count] = rs.getFloat(1);
				System.out.println("wegight_Value: "+rs.getFloat(1));
				count++;
			}
			
			
			
			
			for(int i = 0; i<professor_weight.length; i++) {
				System.out.println(i+"_가중치값 ="+professor_weight[i]);
				if(professor_weight[i] == (float)0.0) {
					System.out.println("기본값으로 수정");
					professor_weight[i] = (float)1.0;
				}
			}
			
			
			rs = stmt.executeQuery("select s.name, f.university_number, t.category_name, avg(test_grade) "
					+ "from Career_Test as f "
					+ "inner join  student as s on s.university_number = f.university_number "
					+ "inner join test_category as t on t.category_number = f.test_category  "
					+ "group by test_category,university_number having (university_number) = '"+university_number+"' order by university_number  "); 
			count = 0;
			while(rs.next()) {
				avg_test_grade[count] = (float) (Math.round(rs.getFloat(4)*10)/10.0);
				
				count++;
				
			}
			
			
			// 통합 점수 = 역량 평균 점수 + 역량별 평균 점수* 가중치값/2
			// 역량별 평균 점수를 가져와야한다.
			
			for(int i = 0; i<avg_test_grade.length; i++) {
				integrated_score_all[i] = (float) (Math.round(((avg_test_grade[i]+(avg_test_grade[i]*professor_weight[i]))/2)*10)/10.0) ;
				
			}
			System.out.println("통합점수 넣을게~~");
			String sql = "insert into Integration_Score values "
					+ "('"+university_number+"', 1,"+avg_test_grade[0]+","+integrated_score_all[0]+"),"
					+ "('"+university_number+"', 2,"+avg_test_grade[1]+","+integrated_score_all[1]+"),"
					+ "('"+university_number+"', 3,"+avg_test_grade[2]+","+integrated_score_all[2]+"),"
					+ "('"+university_number+"', 4,"+avg_test_grade[3]+","+integrated_score_all[3]+"),"
					+ "('"+university_number+"', 5,"+avg_test_grade[4]+","+integrated_score_all[4]+"),"
					+ "('"+university_number+"', 6,"+avg_test_grade[5]+","+integrated_score_all[5]+");";
			System.out.println(sql);
			stmt.execute(sql);
			System.out.println("sucees");
			rs.close();
			stmt.close();
			con.close();
			// 1.자기이해, 2.전공직업정보, 3.진로결정, 4.의사결정, 5.관계 활용자신감, 6.진로준비도
			
			System.out.println("학번:"+university_number+"| 진단 영역: 자기이해     | 영역 평균: "+avg_test_grade[0]+" | 통합 영역 점수: "+integrated_score_all[0]);
			System.out.println("학번:"+university_number+"| 진단 영역: 전공직업정보  | 영역 평균: "+avg_test_grade[1]+" | 통합 영역 점수: "+integrated_score_all[1]);
			System.out.println("학번:"+university_number+"| 진단 영역: 진로결정     | 영역 평균: "+avg_test_grade[2]+" | 통합 영역 점수: "+integrated_score_all[2]);
			System.out.println("학번:"+university_number+"| 진단 영역: 의사결정     | 영역 평균: "+avg_test_grade[3]+" | 통합 영역 점수: "+integrated_score_all[3]);
			System.out.println("학번:"+university_number+"| 진단 영역: 활용자신감   | 영역 평균: "+avg_test_grade[4]+" | 통합 영역 점수: "+integrated_score_all[4]);
			System.out.println("학번:"+university_number+"| 진단 영역: 진로준비도   | 영역 평균: "+avg_test_grade[5]+" | 통합 영역 점수: "+integrated_score_all[5]);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}