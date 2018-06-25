package resultException;

public enum StudentManageExceptionEnums {

	
	CONNECTION_OPEN_ERROR(0,"���ݿ�����ʧ��"),
	CONNECTION_CLOSE_ERROR(1,"���ݿ�ر�ʧ��"),
	STUDENT_NOT_EXIST(2,"��ѯ���󲻴���"),
	INSERT_ERROR(3,"��������ʧ��"),
	DELETE_STUDENTINFO_ERROR(4,"ɾ��ѧ������ʧ��"),
	DATABASE_IS_NULL(5,"���ݿ�Ϊ��"),
	QUERY_ERROR(6,"��ѯ��������"),
	CHANGE_CODE_DONOT_EXIST(7,"ѧ������ȼ�������"),
	PUNISHMENT_LEVELS_DONOT_EXIST(8,"�����ȼ�������"),
	CLASS_INFO_DONOT_EXIST(9,"�༶��Ϣ������"),
	DEPARTMENT_INFO_DONOT_EXIST(10,"Ժϵ��Ϣ������"),
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
