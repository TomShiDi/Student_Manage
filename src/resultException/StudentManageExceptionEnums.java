package resultException;

public enum StudentManageExceptionEnums {

	
	CONNECTION_OPEN_ERROR(0,"数据库连接失败"),
	CONNECTION_CLOSE_ERROR(1,"数据库关闭失败"),
	STUDENT_NOT_EXIST(2,"查询对象不存在"),
	INSERT_ERROR(3,"插入数据失败"),
	DELETE_STUDENTINFO_ERROR(4,"删除学生数据失败"),
	DATABASE_IS_NULL(5,"数据库为空"),
	QUERY_ERROR(6,"查询操作出错"),
	CHANGE_CODE_DONOT_EXIST(7,"学籍变更等级不存在"),
	PUNISHMENT_LEVELS_DONOT_EXIST(8,"处罚等级不存在"),
	CLASS_INFO_DONOT_EXIST(9,"班级信息不存在"),
	DEPARTMENT_INFO_DONOT_EXIST(10,"院系信息不存在"),
	;
	
	private String message;
	
	private Integer code;

	private StudentManageExceptionEnums( Integer code,String message) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public Integer getCode() {
		return code;
	};
	
	
	
	
}
