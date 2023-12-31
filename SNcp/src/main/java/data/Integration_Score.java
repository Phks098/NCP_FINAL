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
	String url = "jdbc:mysql://localhost:3306/NCP";
	String id = "root";
	String password = "1234";

	String university_number;
	int test_category;
	float category_everage;
	float integrated_score;

	public Integration_Score() {

	}

	Integration_Score(String university_number, int test_category, float category_everage, float integrated_score) {
		this.university_number = university_number;
		this.test_category = test_category;
		this.category_everage = category_everage;
		this.integrated_score = integrated_score;
	}

	public void InsertInto_Integration_Score(String university_number) {

		float[] professor_weight = new float[6];
		float[] avg_test_grade = new float[6];
		float[] integrated_score_all = new float[6];

		try {
			con = DriverManager.getConnection(url, id, password);
			stmt = con.createStatement();

			rs = stmt.executeQuery(
					"select w.weight from Professor_Career_Evaluation as p " + "inner join professor_weight as w "
							+ "on p.evaluation_grade = w.evaluation_grade where university_number ='"
							+ university_number + "'");

			int count = 0;
			if (rs == null) {
				System.out.println("평가가 없습니다.");
			} else {
				while (rs.next()) {
					professor_weight[count] = rs.getFloat(1);
					System.out.println("wegight_Value: " + rs.getFloat(1));
					count++;
				}

			}

			for (int i = 0; i < professor_weight.length; i++) {

				if (professor_weight[i] == (float) 0.0) {
					professor_weight[i] = (float) 1.0;
				}
			}

			rs = stmt.executeQuery(
					"select s.name, f.university_number, t.category_name, avg(test_grade) " + "from Career_Test as f "
							+ "inner join  student as s on s.university_number = f.university_number "
							+ "inner join test_category as t on t.category_number = f.test_category  "
							+ "group by test_category,university_number having (university_number) = '"
							+ university_number + "' order by university_number  ");
			count = 0;
			while (rs.next()) {
				avg_test_grade[count] = (float) (Math.round(rs.getFloat(4) * 10) / 10.0);

				count++;

			}

			for (int i = 0; i < avg_test_grade.length; i++) {
				integrated_score_all[i] = (float) (Math
						.round(((avg_test_grade[i] + (avg_test_grade[i] * professor_weight[i])) / 2) * 10) / 10.0);

			}
			System.out.println("가중치값 넣을게~");
			String sql = "insert into Integration_Score values " + "('" + university_number + "', 1,"
					+ avg_test_grade[0] + "," + integrated_score_all[0] + ")," + "('" + university_number + "', 2,"
					+ avg_test_grade[1] + "," + integrated_score_all[1] + ")," + "('" + university_number + "', 3,"
					+ avg_test_grade[2] + "," + integrated_score_all[2] + ")," + "('" + university_number + "', 4,"
					+ avg_test_grade[3] + "," + integrated_score_all[3] + ")," + "('" + university_number + "', 5,"
					+ avg_test_grade[4] + "," + integrated_score_all[4] + ")," + "('" + university_number + "', 6,"
					+ avg_test_grade[5] + "," + integrated_score_all[5] + ");";
			System.out.println(sql);
			stmt.execute(sql);
			System.out.println("sucees");
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}