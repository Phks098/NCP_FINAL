package data.vo;

public class Professor_education_identity_test_VO {
	String university_number;
	int test_category;
	int evaluation_grade;
	String professor_number;
	String evaluation_date;
	
	
	public Professor_education_identity_test_VO() {
		super();
	}
	public Professor_education_identity_test_VO(String university_number, int test_category, int evaluation_grade,
			String professor_number, String evaluation_date) {
		super();
		this.university_number = university_number;
		this.test_category = test_category;
		this.evaluation_grade = evaluation_grade;
		this.professor_number = professor_number;
		this.evaluation_date = evaluation_date;
	}
	public String getUniversity_number() {
		return university_number;
	}
	public void setUniversity_number(String university_number) {
		this.university_number = university_number;
	}
	public int getTest_category() {
		return test_category;
	}
	public void setTest_category(int test_category) {
		this.test_category = test_category;
	}
	public int getEvaluation_grade() {
		return evaluation_grade;
	}
	public void setEvaluation_grade(int evaluation_grade) {
		this.evaluation_grade = evaluation_grade;
	}
	public String getProfessor_number() {
		return professor_number;
	}
	public void setProfessor_number(String professor_number) {
		this.professor_number = professor_number;
	}
	public String getEvaluation_date() {
		return evaluation_date;
	}
	public void setEvaluation_date(String evaluation_date) {
		this.evaluation_date = evaluation_date;
	}
	@Override
	public String toString() {
		return "Professor_education_identity_test_VO [university_number=" + university_number + ", test_category="
				+ test_category + ", evaluation_grade=" + evaluation_grade + ", professor_number=" + professor_number
				+ ", evaluation_date=" + evaluation_date + "]";
	}
	
	
}
