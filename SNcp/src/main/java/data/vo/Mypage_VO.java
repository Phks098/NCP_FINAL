package data.vo;

public class Mypage_VO {
	String university_number;
	float category_score;
	String capability_name;
	int preparation_degree;
	String preparation_level;
	int preparation_rank;
	
	public Mypage_VO(String university_number, float category_score, String capability_name, int preparation_degree,
			String preparation_level, int preparation_rank) {
		super();
		this.university_number = university_number;
		this.category_score = category_score;
		this.capability_name = capability_name;
		this.preparation_degree = preparation_degree;
		this.preparation_level = preparation_level;
		this.preparation_rank = preparation_rank;
	}
	
	public Mypage_VO() {
		super();
	}
	public String getUniversity_number() {
		return university_number;
	}
	public void setUniversity_number(String university_number) {
		this.university_number = university_number;
	}
	public float getCategory_score() {
		return category_score;
	}
	public void setCategory_score(float category_score) {
		this.category_score = category_score;
	}
	public String getCapability_name() {
		return capability_name;
	}
	public void setCapability_name(String capability_name) {
		this.capability_name = capability_name;
	}
	public int getPreparation_degree() {
		return preparation_degree;
	}
	public void setPreparation_degree(int preparation_degree) {
		this.preparation_degree = preparation_degree;
	}
	public String getPreparation_level() {
		return preparation_level;
	}
	public void setPreparation_level(String preparation_level) {
		this.preparation_level = preparation_level;
	}
	public int getPreparation_rank() {
		return preparation_rank;
	}
	public void setPreparation_rank(int preparation_rank) {
		this.preparation_rank = preparation_rank;
	}
	
	@Override
	public String toString() {
		return "Mypage_VO [university_number=" + university_number + ", category_score=" + category_score
				+ ", capability_name=" + capability_name + ", preparation_degree=" + preparation_degree
				+ ", preparation_level=" + preparation_level + ", preparation_rank=" + preparation_rank + "]";
	}
	
	
}
