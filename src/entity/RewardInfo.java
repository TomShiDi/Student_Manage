package entity;

import java.util.Date;

public class RewardInfo {
	
	private String id;
	
	private String studentId;
	
	private String levels;
	
	private Date rec_time;
	
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public Date getRec_time() {
		return rec_time;
	}

	public void setRec_time(Date rec_time) {
		this.rec_time = rec_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String discrition) {
		this.description = discrition;
	}

	@Override
	public String toString() {
		return "reward_info [id=" + id + ", studentId=" + studentId + ", levels=" + levels + ", rec_time=" + rec_time
				+ ", description=" + description + "]";
	}

	public RewardInfo(String id, String studentId, String levels, String description) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.levels = levels;
		this.description = description;
	}
	
	public RewardInfo(){}
	
}
