package entity;

import java.util.Date;

public class PunishmentInfo {

	private String id;
	
	private String studentid;
	
	private String levels;
	
	private Date rec_time;
	
	private String enable;
	
	private String discription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "PunishmentInfo [id=" + id + ", studentid=" + studentid + ", levels=" + levels + ", rec_time=" + rec_time
				+ ", enable=" + enable + ", discription=" + discription + "]";
	}

	public PunishmentInfo(String id, String studentid, String levels,String enable,
			String discription) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.levels = levels;
		this.enable = enable;
		this.discription = discription;
	}

	
	public PunishmentInfo(){}
	
	
	
}
