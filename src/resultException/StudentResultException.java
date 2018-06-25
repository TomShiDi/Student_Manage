package resultException;

public class StudentResultException extends RuntimeException{
	
	private Integer code;
	public StudentResultException(Integer code,String message)
	{
		super(message);
		this.code=code;
	}
	
	public StudentResultException(StudentManageExceptionEnums studentManageExceptionEnums)
	{
		super(studentManageExceptionEnums.getMessage());
		this.code=studentManageExceptionEnums.getCode();
	}
}
