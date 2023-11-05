package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prototype_Setting {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String Driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost/ncp?serverTimezone=UTC";
	String id = "root";
	String password = "1234";
	
	
	public void setScore(String student) {
		
		String sql = "insert into Career_Test values "
				+"('"+student+"',1,"+3+",1,now()),"
				+"('"+student+"',2,"+3+",1,now()),"
				+"('"+student+"',3,"+3+",1,now()),"
				+"('"+student+"',4,"+3+",1,now()),"
				+"('"+student+"',5,"+3+",1,now()),"
				+"('"+student+"',6,"+3+",2,now()),"
				+"('"+student+"',7,"+3+",2,now()),"
				+"('"+student+"',8,"+3+",2,now()),"
				+"('"+student+"',9,"+3+",2,now()),"
				+"('"+student+"',10,"+3+",2,now()),"
				+"('"+student+"',11,"+3+",2,now()),"
				+"('"+student+"',12,"+3+",3,now()),"
				+"('"+student+"',13,"+3+",3,now()),"
				+"('"+student+"',14,"+3+",3,now()), "
				+"('"+student+"',15,"+3+",3,now()), "
				+"('"+student+"',16,"+3+",3,now()), "
				+"('"+student+"',17,"+3+",4,now()), "
				+"('"+student+"',18,"+3+",4,now()), "
				+"('"+student+"',19,"+3+",4,now()), "
				+"('"+student+"',20,"+3+",4,now()), "
				+"('"+student+"',21,"+3+",4,now()), "
				+"('"+student+"',22,"+3+",4,now()), "
				+"('"+student+"',23,"+3+",5,now()), "
				+"('"+student+"',24,"+3+",5,now()), "
				+"('"+student+"',25,"+3+",5,now()), "
				+"('"+student+"',26,"+3+",5,now()), "
				+"('"+student+"',27,"+3+",5,now()), "
				+"('"+student+"',28,"+3+",5,now()), "
				+"('"+student+"',29,"+3+",6,now()), "
				+"('"+student+"',30,"+3+",6,now()), "
				+"('"+student+"',31,"+3+",6,now()), "
				+"('"+student+"',32,"+3+",6,now()), "
				+"('"+student+"',33,"+3+",6,now()), "
				+"('"+student+"',34,"+3+",6,now()), "
				+"('"+student+"',35,"+3+",6,now())";
		
		try {
			con = DriverManager.getConnection(url,id,password);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("입력 성공");
			
			
			stmt.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
		
		
		
	}
	public void setEvalution(String student) {
		String sql =" insert into Professor_Career_Evaluation values "
				+ "  ("+student+",1,5,"+10008+",now()), "
				+ "  ("+student+",2,5,"+10008+",now()), "
				+ "  ("+student+",3,5,"+10008+",now()), "
				+ "  ("+student+",4,5,"+10008+",now()), "
				+ "  ("+student+",5,5,"+10008+",now()), "
				+ "  ("+student+",6,5,"+10008+",now()) ";
		
		try {
			con = DriverManager.getConnection(url,id,password);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("평가지 Defualt값으로 입력 완료(Defualt == 3점)");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
