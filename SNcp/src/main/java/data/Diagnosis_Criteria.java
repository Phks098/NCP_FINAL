package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Diagnosis_Criteria {
	int category;
	float high_max;
	float high_min;
	float normal_max;
	float normal_min;
	float low_max;
	float low_min;
	
	String state;
	float persent;
	
	Connection con;
	Statement stmt;
	ResultSet rs;

	String Driver = "com.mysql.cj.jdbc.Driver";
	String url ="jdbc:mysql://localhost:3306/NCP";
	String id = "root";
	String password = "1234";
	
	
	public Perset_state Check_Level(int category, float score) {
		Perset_state ss = new Perset_state();
		try {
			con = DriverManager.getConnection(url,id,password);
			stmt = con.createStatement();
			String sql = "select * from Diagnosis_Criteria where  capability_category = "+ category;
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				high_max = rs.getFloat(2);
				high_min = rs.getFloat(3);
				normal_max = rs.getFloat(4);
				normal_min = rs.getFloat(5);
				low_max = rs.getFloat(6);
				low_min = rs.getFloat(7);
				
			}
			
			if(score >= high_min) {
				ss.state = "높음";
			}
			 if(normal_max >=score && normal_min<score ) {
				 ss.state = "보통";
			} if(low_max >= score) {
				 ss.state = "낮음";
			}
			
			ss.persent =Math.round(((score/high_max)*100));
			
			con.close();
			stmt.close();
			rs.close();
			
		}catch(SQLException e) {
			
		}
		return ss;
	}
	
}