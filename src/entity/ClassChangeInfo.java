package entity;

import java.util.Date;

public class ClassChangeInfo {
	
	private String id;
	
	private String studentId;
	
	private String changeCode;
	
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

	public String getChangeCode() {
		return changeCode;
	}

	public void setChangeCode(String changeCode) {
		this.changeCode = changeCode;
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

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "class_change_info [id=" + id + ", studentId=" + studentId + ", change=" + changeCode + ", rec_time="
				+ rec_time + ", discription=" + description + "]";
	}

	public ClassChangeInfo(String id, String studentId, String changeCode, String description) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.changeCode = changeCode;
		this.description = description;
	}
	
	public ClassChangeInfo(){}
	
}
