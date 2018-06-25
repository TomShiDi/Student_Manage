package entity;

public class StudentInfo {
	
	private String studentId;
	
	private String name;
	
	private String sex;
	
	private String classNum;
	
	private String department;
	
	private String birthday;
	
	private String native_place;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNative_place() {
		return native_place;
	}

	public void setNative_place(String native_place) {
		this.native_place = native_place;
	}

	@Override
	public String toString() {
		return "student_info [studentId=" + studentId + ", name=" + name + ", sex=" + sex + ", classNum=" + classNum
				+ ", department=" + department + ", birthday=" + birthday + ", native_place=" + native_place + "]";
	}

	public StudentInfo(String studentId, String name, String sex, String classNum, String department, String birthday,
			String native_place) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.sex = sex;
		this.classNum = classNum;
		this.department = department;
		this.birthday = birthday;
		this.native_place = native_place;
	}
	
	public StudentInfo(){}
	
}
