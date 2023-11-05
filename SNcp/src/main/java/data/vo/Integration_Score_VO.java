package data.vo;

public class Integration_Score_VO {
	String university_number;
	int test_category;
	float category_everage;
	float integrated_score;

	public Integration_Score_VO(String university_number, int test_category, float category_everage,
			float integrated_score) {
		super();
		this.university_number = university_number;
		this.test_category = test_category;
		this.category_everage = category_everage;
		this.integrated_score = integrated_score;
	}

	public Integration_Score_VO() {
		super();
	}

	@Override
	public String toString() {
		return "Integration_Score_VO [university_number=" + university_number + ", test_category=" + test_category
				+ ", category_everage=" + category_everage + ", integrated_score=" + integrated_score + "]";
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

	public float getCategory_everage() {
		return category_everage;
	}

	public void setCategory_everage(float category_everage) {
		this.category_everage = category_everage;
	}

	public float getIntegrated_score() {
		return integrated_score;
	}

	public void setIntegrated_score(float integrated_score) {
		this.integrated_score = integrated_score;
	}

}
