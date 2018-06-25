package entity;

public class RewardLevelsInfo {

	private Integer code;
	
	private String description;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RewardLevelsInfo [code=" + code + ", description=" + description + "]";
	}
	
	
	
}
