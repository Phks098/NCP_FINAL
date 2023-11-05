package data.vo;

public class Capability_category_VO {
	String capability_number;
	String capability_name;
	public Capability_category_VO() {
		super();
	}
	public Capability_category_VO(String capability_number, String capability_name) {
		super();
		this.capability_number = capability_number;
		this.capability_name = capability_name;
	}
	public String getCapability_number() {
		return capability_number;
	}
	public void setCapability_number(String capability_number) {
		this.capability_number = capability_number;
	}
	public String getCapability_name() {
		return capability_name;
	}
	public void setCapability_name(String capability_name) {
		this.capability_name = capability_name;
	}
	@Override
	public String toString() {
		return "Capability_category_VO [capability_number=" + capability_number + ", capability_name=" + capability_name
				+ "]";
	}
	
	
}
